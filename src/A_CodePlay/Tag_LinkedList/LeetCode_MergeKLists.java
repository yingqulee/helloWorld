package A_CodePlay.Tag_LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表 困难
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */

public class LeetCode_MergeKLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        ListNode(Integer[] nums) {
            ListNode currNode = this;
            currNode.val = nums[0];
            for (int i = 1; i < nums.length; i++) {
                currNode.next = new ListNode(nums[i]);
                currNode = currNode.next;
            }
        }

        @Override
        public String toString() {
            ListNode currNode = this;
            StringBuilder s = new StringBuilder();
            while (currNode != null) {
                s.append(currNode.val);
                s.append(" -> ");
                currNode = currNode.next;
            }
            // 最后添加一个 NULL 标志表示添加到末尾了
            s.append("NULL");
            return s.toString();
        }
    }
    /**分治法,两两合并
     * 分治, 分成两个链表的时候就合并;
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return merge(lists[0], lists[1]);
        }

        int mid = lists.length/2;
        ListNode[] l1 = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            l1[i] = lists[i];
        }

        ListNode[] l2 = new ListNode[lists.length-mid];
        for (int i = 0, j = mid; j < lists.length; i++, j++) {
            l2[i] = lists[j];
        }
        return merge(mergeKLists(l1),mergeKLists(l2));
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = merge(l1.next, l2);
        } else {
            head = l2;
            head.next = merge(l1, l2.next);
        }
        return head;
    }

    /**最小堆
     * 用容量为K的最小堆优先队列，把链表的头结点都放进去，然后出队当前优先队列中最小的，挂上链表，
     * 然后让出队的那个节点的下一个入队，再出队当前优先队列中最小的，直到优先队列为空。
     */
    public ListNode mergeKListsII(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {  //lambda写法:len, Comparator.comparingInt(a -> a.val)
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        while (!minHeap.isEmpty()) {
            ListNode nextNode = minHeap.poll();
            cur.next = nextNode;
            cur = cur.next;
            if (nextNode.next != null) {
                minHeap.offer(nextNode.next);
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Integer[] nums1 = {1, 4, 5};
        Integer[] nums2 = {1, 3, 4};
        Integer[] nums3 = {2, 6};
        ListNode head1 = new ListNode(nums1);
        ListNode head2 = new ListNode(nums2);
        ListNode head3 = new ListNode(nums3);
        ListNode[] lists = new ListNode[3];
        lists[0] = head1;
        lists[1] = head2;
        lists[2] = head3;
        LeetCode_MergeKLists solution = new LeetCode_MergeKLists();
        ListNode mergeKLists = solution.mergeKListsII(lists);
        System.out.println(mergeKLists);
    }
}
