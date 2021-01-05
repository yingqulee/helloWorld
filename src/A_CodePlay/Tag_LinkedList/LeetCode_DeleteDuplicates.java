package A_CodePlay.Tag_LinkedList;

/** 83. 删除排序链表中的重复元素 简单
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class LeetCode_DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while(current != null && current.next != null){
            if (current.val == current.next.val){
                ListNode node = current.next;
                current.next = node.next;
                node.next = null;//清除野指针
            } else {
                current = current.next;
            }
        }
        return head;
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

        ListNode list = deleteDuplicates(l1);
        while(list != null){
            System.out.println(list.getVal()+" ");
            list = list.next;
        }
    }
}
