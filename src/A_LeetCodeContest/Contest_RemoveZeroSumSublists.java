package A_LeetCodeContest;

import java.util.Arrays;

/**5164. 从链表中删去总和值为零的连续节点
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * 删除完毕后，请你返回最终结果链表的头节点。
 * 你可以返回任何满足题目要求的答案。
 *
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 * 示例 1：
 *
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 * 示例 2：
 *
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 * 示例 3：
 *
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 */
public class Contest_RemoveZeroSumSublists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        int[] node = new int[2000];
        int idx = 0;
        while (head != null) {
            node[idx++] = head.val;
            head = head.next;
        }
        int n = idx;
        node = Arrays.copyOf(node, n);

        int[] cum = new int[n+1];
        for (int i = 0;i < n;i++) {
            cum[i+1] = cum[i] + node[i];
        }
        boolean[] flag = new boolean[n];
        for (int i = 0; i <= n; i++) {
            for (int j = 0;j < i;j++) {
                if (cum[j] == cum[i] && !flag[j]) {
                    for (int k = j; k < i; k++) flag[k] = true;
                    break;
                }
            }
        }
        ListNode root = null;
        for (int i = n-1;i >= 0;i--) {
            if (!flag[i]) {
                ListNode x = new ListNode(node[i]);
                x.next = root;
                root = x;
            }
        }
        return root;
    }
}
