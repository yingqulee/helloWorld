package A_CodePlay.Tag_LinkedList;

/**
 * 2. 两数相加 中等
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class LeetCode_2_AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyHead;
        int carry = 0;
        while(p != null || q != null){

            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0){
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l1_1 = new ListNode(4);
        ListNode l1_2 = new ListNode(3);
        l1.setNext(l1_1);
        l1_1.setNext(l1_2);

        ListNode l2 = new ListNode(5);
        ListNode l2_1 = new ListNode(6);
        ListNode l2_2 = new ListNode(4);
        l2.setNext(l2_1);
        l2_1.setNext(l2_2);

        ListNode list = LeetCode_2_AddTwoNumbers.addTwoNumbers(l1,l2);
        while(list != null){
            System.out.print(list.getVal()+" ");
            list = list.next;
        }
    }
}
