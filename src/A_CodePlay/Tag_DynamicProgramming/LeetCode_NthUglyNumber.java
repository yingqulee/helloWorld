package A_CodePlay.Tag_DynamicProgramming;

import java.util.Arrays;

/**
 * 264. 丑数 II 中等
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 */
public class LeetCode_NthUglyNumber {
    /**
     * 丑数求解过程：首先除2，直到不能整除为止，然后除5到不能整除为止，然后除3直到不能整除为止。
     * 最终判断剩余的数字是否为1，如果是1则为丑数，否则不是丑数
     * <p>
     * 解题思路：
     * 从1开始遍历，按丑数求解过程找出满足条件的第n个丑数（提交超时）
     * 思路优化（如何利用之前的计算）
     * 解题二：动态规划+三指针
     * dp保存按序排列的丑数，三指针分别是*2，*3，*5，找出下一个丑数
     */
    public static int[] nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[i2] * 2,Math.min(dp[i3] * 3, dp[i5] * 5));
            if (min == dp[i2] * 2) i2++;
            if (min == dp[i3] * 3) i3++;
            if (min == dp[i5] * 5) i5++;
            dp[i] = min;
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] num = nthUglyNumber(10);
        System.out.println(Arrays.toString(num));
    }
}
