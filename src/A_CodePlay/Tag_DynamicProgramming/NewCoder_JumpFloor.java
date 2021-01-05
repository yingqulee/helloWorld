package A_CodePlay.Tag_DynamicProgramming;

import java.util.Arrays;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * I:一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * II:一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class NewCoder_JumpFloor {

    //斐波那契
    public int JumpFloorI(int target) {
        return 0;
    }

    /**
     * 思路:数学推导
     * 跳上 n-1 级台阶，可以从 n-2 级跳 1 级上去，也可以从 n-3 级跳 2 级上去...，那么
     * f(n-1) = f(n-2) + f(n-3) + ... + f(0)
     *
     * 同样，跳上 n 级台阶，可以从 n-1 级跳 1 级上去，也可以从 n-2 级跳 2 级上去... ，那么
     * f(n) = f(n-1) + f(n-2) + ... + f(0)
     *
     * 综上可得
     * f(n) - f(n-1) = f(n-1)
     * 即f(n) = 2*f(n-1)
     * 所以 f(n) 是一个等比数列
     */
    public static int JumpFloorII(int target) {
        //return (int) Math.pow(2, target - 1);

        //动态规划
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII(10));
    }
}
