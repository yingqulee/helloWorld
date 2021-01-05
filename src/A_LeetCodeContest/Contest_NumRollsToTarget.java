package A_LeetCodeContest;

import java.util.Arrays;

/**1155. 掷骰子的N种方法
 * 这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。
 *
 * 我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。
 *
 * 如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模10^9 + 7 后返回。
 *
 * 示例 1：
 *
 * 输入：d = 1, f = 6, target = 3
 * 输出：1
 * 示例 2：
 *
 * 输入：d = 2, f = 6, target = 7
 * 输出：6
 * 示例 3：
 *
 * 输入：d = 2, f = 5, target = 10
 * 输出：1
 * 示例 4：
 *
 * 输入：d = 1, f = 2, target = 3
 * 输出：0
 * 示例 5：
 *
 * 输入：d = 30, f = 30, target = 500
 * 输出：222616187
 */
public class Contest_NumRollsToTarget {

    static int mod = 1000000007;

    public static int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[1010][31];
        for (int i = 0; i < 1010; i++) Arrays.fill(dp[i], -1);
        return helper(target, f, d,dp);
    }

    private static int helper(int target, int f, int d, int[][] dp) {
        if (d == 0) return target == 0 ? 1: 0;
        if (target <= 0) return 0;
        if (dp[target][d] != -1) return dp[target][d];

        int res = 0;
        for (int i = 1; i <= f; i++) {
            res += helper(target - i, f, d-1, dp);
            res %= mod;
        }
        return dp[target][d] = res;
    }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(1,6,3));
    }
}
