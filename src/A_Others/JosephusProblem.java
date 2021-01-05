package A_Others;

/**约瑟夫环问题
 * 编号 1-N 的 N 个士兵围坐在一起形成一个圆圈,从编号为 1 的士兵开始依次报数,
 * 数到 M 的士兵出局, 之后的士兵再从 1 开始报数.直到剩下最后一位, 求这个士兵的编号
 *
 * 例如 N = 6，M = 5，出局的顺序是：5，4，6，2，3。
 */
public class JosephusProblem {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**环形链表解决约瑟夫环
     * 时间复杂度: O(N * M)
     * 空间复杂度: O(N);
     */
    private int josephusProblemI(int N, int M) {
        if (M == 1 || N < 2) {
            return N;
        }
        //创建环形链表
        ListNode head = cycleLinkedList(N);
        //遍历删除
        int count = 1;
        ListNode cur = head;
        ListNode pre = null;
        while (head.next != head) {
            //删除
            if (count == M) {
                pre.next = cur.next;
                cur = pre.next;
                count = 1;
            } else {
                count++;
                pre = cur;
                cur = cur.next;
            }
        }
        return head.val;
    }

    private ListNode cycleLinkedList(int n) {
        ListNode head = new ListNode(1);
        ListNode next = head;
        for (int i = 2; i <= n; i++) {
            ListNode tmp = new ListNode(i);
            next.next = tmp;
            next = next.next;
        }
        //头尾相连
        next.next = head;
        return head;
    }

    /**递归解决约瑟夫环
     * 找出 f(n, m) 与 f(n-1, m) 之间的关系
     * 假设 old 为删除之前的编号, new 为删除了一个节点之后的编号, 则
     * old 与 new 之间的关系为 old = (new + M - 1) % N + 1
     * 当 N == 1 时, f(1, m) = 1;
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     */
    private int josephusProblemII(int N, int M) {
        return N == 1 ? N : (josephusProblemII(N - 1, M) + M - 1) % N + 1;
    }

    public static void main(String[] args) {
        JosephusProblem josephusProblem = new JosephusProblem();
        int resI = josephusProblem.josephusProblemI(6, 5);
        int resII = josephusProblem.josephusProblemII(6, 4);
        System.out.println(resI+" "+resII);
    }
}
