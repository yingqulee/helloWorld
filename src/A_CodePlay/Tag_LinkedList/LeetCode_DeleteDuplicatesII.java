package A_CodePlay.Tag_LinkedList;

/**
 * 82. 删除排序链表中的重复元素 II 中等
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 */
public class LeetCode_DeleteDuplicatesII {

    //递归
    public ListNode deleteDuplicatesI(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        if (head.val == cur.val) {
            while (cur != null && head.val == cur.val) {
                cur = cur.next;
            }
            return deleteDuplicatesI(cur);
        } else {
            head.next = deleteDuplicatesI(head.next);
            return head;
        }
    }

    //遍历
    public ListNode deleteDuplicatesII(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur != null && cur.next != null && cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                }
                pre.next = cur.next;
                cur = pre.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);
        l4.setNext(l5);
        LeetCode_DeleteDuplicatesII l = new LeetCode_DeleteDuplicatesII();
        ListNode list = l.deleteDuplicatesII(l1);
        while(list != null) {
            System.out.println(list.getVal()+" ");
            list = list.next;
        }
    }
}
