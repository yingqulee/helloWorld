package A_CodePlay.Tag_LinkedList;

/**
 * 61. 旋转链表 中等
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 */
public class LeetCode_61_RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode node = head;
        int len = 1;
        while (node.next != null) {
            node = node.next;
            len++;
        }
        k %= len;
        if (k == 0) {
            return head;
        }
        node.next = head;
        for (int i = 0; i < len - k; i++) {
            node = node.next;
        }
        ListNode newHead = node.next;
        node.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode list = new LeetCode_61_RotateRight().rotateRight(l1, 2);
        while (list.next != null) {
            System.out.print(list.val+"->");
            list = list.next;
        }
        System.out.print(list.val);
    }
}
