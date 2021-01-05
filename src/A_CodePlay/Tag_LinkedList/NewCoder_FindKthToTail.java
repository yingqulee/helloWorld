package A_CodePlay.Tag_LinkedList;

import java.util.Stack;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点 简单
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，
 * 它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 */
public class NewCoder_FindKthToTail {

    /**
     * 思路:
     * 设链表的长度为 N。设置两个指针 P1 和 P2，先让 P1 移动 K 个节点，则还有 N - K 个节点可以移动。
     * 此时让 P1 和 P2 同时移动，可以知道当 P1 移动到链表结尾时，
     * P2 移动到第 N - K 个节点处，该位置就是倒数第 K 个节点。
     */
    public static ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) return null;
        ListNode p1 = head;
        while(p1 != null && k-- > 0) p1 = p1.next;
        if (k > 0)return null;

        ListNode p2 = head;
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(FindKthToTail(node1, 2).toString());

    }
}
