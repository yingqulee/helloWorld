package A_CodePlay.Tag_Greedy;

/**
 * 1578. 避免重复字母的最小删除成本 中等
 * 给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
 *
 * 返回使字符串任意相邻两个字母不相同的最小删除成本。
 *
 * 请注意，删除一个字符后，删除其他字符的成本不会改变。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abaac", cost = [1,2,3,4,5]
 * 输出：3
 * 解释：删除字母 "a" 的成本为 3，然后得到 "abac"（字符串中相邻两个字母不相同）。
 * 示例 2：
 *
 * 输入：s = "abc", cost = [1,2,3]
 * 输出：0
 * 解释：无需删除任何字母，因为字符串中不存在相邻两个字母相同的情况。
 * 示例 3：
 *
 * 输入：s = "aabaa", cost = [1,2,3,4,1]
 * 输出：2
 * 解释：删除第一个和最后一个字母，得到字符串 ("aba") 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-deletion-cost-to-avoid-repeating-letters
 */
public class LeetCode_1578_MinCost {

    public int minCost(String s, int[] cost) {
        //String换char[]会更快。
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                res += Math.min(cost[i], cost[i + 1]);
                //去掉一个最小的 更新一个最大的 cost
                cost[i + 1] = Math.max(cost[i], cost[i + 1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] cost = {3,5,10,7,5,3,5,5,4,8,1};
        System.out.println(new LeetCode_1578_MinCost().minCost("aaabbbabbbb", cost));
    }
}
