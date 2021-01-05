package A_LeetCodeContest;

import java.util.Arrays;

/**5173. 质数排列
 * 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数的索引」上；你需要返回可能的方案总数。
 *
 * 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 *
 * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
 *
 * 示例 1：
 *
 * 输入：n = 5
 * 输出：12
 * 解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
 * 示例 2：
 *
 * 输入：n = 100
 * 输出：682289015
 */
public class Contest_NumPrimeArrangements {

    public static boolean countPrimes(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static long F(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            res = res % 1000000007;
        }
        return res;
    }
    public static int numPrimeArrangements(int n) {
        int num = 0;
        for (int i = 2; i <= n; i++) {
            if (countPrimes(i)) {
                num++;
            }
        }
        int idx = n - num;
        System.out.println(num + " " + idx);
        return (int)(F(num) * F(idx) % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(numPrimeArrangements(100));
    }
}
