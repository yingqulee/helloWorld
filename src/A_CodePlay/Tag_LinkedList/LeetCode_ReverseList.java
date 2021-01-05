package A_CodePlay.Tag_LinkedList;

/**
 * 206. 反转链表 简单
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class LeetCode_ReverseList {

    /**
     * 迭代方法
     * 1->2->3->4->5->NULL
     * NULL<-1<-2<-3<-4<-5
     *
     * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，
     * 因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        //前指针
        ListNode pre = null;
        //当前指针
        ListNode cur = head;

        //每次循环,都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (cur != null) {
            ListNode nextTemp = cur.next;//临时节点，暂存当前节点的下一节点，用于后移
            cur.next = pre; //将当前节点指向它前面的节点
            pre = cur; //前指针后移
            cur = nextTemp; //当前指针后移
        }

        return pre;
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

        ListNode list = reverseList(l1);
        while(list != null){
            System.out.print(list.val+"->");
            list = list.next;
        }
    }
}
