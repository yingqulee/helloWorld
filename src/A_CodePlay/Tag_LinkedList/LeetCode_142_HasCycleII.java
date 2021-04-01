package A_CodePlay.Tag_LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II 中等
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 */
public class LeetCode_142_HasCycleII {
    /**
     * 思路:双指针
     * 这里我们初始化两个指针 - 快指针和慢指针。
     * 我们每次移动慢指针一步、快指针两步，直到快指针无法继续往前移动。
     * 如果在某次移动后，快慢指针指向了同一个节点，我们就返回它。
     * 否则，我们继续，直到 while 循环终止且没有返回任何节点，这种情况说明没有成环，我们返回 null
     *
     * 给定阶段 1 找到的相遇点，阶段 2 将找到环的入口。
     * 首先我们初始化额外的两个指针： ptr1 ，指向链表的头， ptr2 指向相遇点。
     * 然后，我们每次将它们往前移动一步，直到它们相遇，它们相遇的点就是环的入口，返回这个节点
     */
    private ListNode getIntersect(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;
        //求出第一次相遇的节点
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return tortoise;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }
        //如果是一个环.根据相遇的节点一步一步走,再次相遇就是第一次环出现的地方
        //否则,快指针首先到达空节点,并返回
        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    //Set存储访问过的节点,如果有环,则返回的一定是出现环的第一个节点.
    public ListNode detectCycleII(ListNode head) {
        ListNode res = head;
        Set<ListNode> set = new HashSet<>();

        while(res != null){
            if (set.contains(res)){
                return res;
            }
            set.add(res);
            res = res.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(4);
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(l4);
        l4.setNext(l2);
        LeetCode_142_HasCycleII h = new LeetCode_142_HasCycleII();
        System.out.println(h.detectCycle(l1).val);
    }
}
