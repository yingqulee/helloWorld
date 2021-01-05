package A_CodePlay.Tag_LinkedList;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 */
public class NewCoder_PrintListFromTailToHead {

    /**
     * 思路:递归
     * 要逆序打印链表 1->2->3（3,2,1)，可以先逆序打印链表 2->3(3,2)，最后再打印第一个节点 1。
     * 而链表 2->3 可以看成一个新的链表，要逆序打印该链表可以继续使用求解函数，也就是在求解函数中调用自己，这就是递归函数。
     *
     * @param listNode
     * @return ans
     */
    public ArrayList<Integer> printListFromTailToHead01(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (listNode != null){
            ans.addAll(printListFromTailToHead01(listNode.next));
            ans.add(listNode.val);
        }
        return ans;
    }

    /**
     * 思路:头插法
     * 使用头插法可以得到一个逆序的链表。
     * 头结点和第一个节点的区别：
     * 头结点是在头插法中使用的一个额外节点，这个节点不存储值；
     * 第一个节点就是链表的第一个真正存储值的节点。
     *
     * @param listNode
     * @return ans
     */
    public ArrayList<Integer> printListFromTailToHead02(ListNode listNode) {
        ListNode head = new ListNode(-1);
        // 头插法构建逆序链表
        while (listNode != null) {
            ListNode cur = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = cur;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ans.add(head.val);
            head = head.next;
        }
        return ans;
    }

    /**
     * 思路:栈
     * 栈具有后进先出的特点，在遍历链表时将值按顺序放入栈中，最后出栈的顺序即为逆序。
     * @param listNode
     * @return ans
     */
    public ArrayList<Integer> printListFromTailToHead03(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        if (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!stack.empty())ans.add(stack.pop());
        return ans;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        NewCoder_PrintListFromTailToHead listN = new NewCoder_PrintListFromTailToHead();
        ArrayList<Integer> list = listN.printListFromTailToHead02(listNode1);
        System.out.println(list);
    }
}
