package A_CodePlay.Tag_DynamicProgramming;

/**
 * 70. 爬楼梯 简单
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 思路:https://mp.weixin.qq.com/s/3h9iqU4rdH3EIy5m6AzXsg
 */
public class LeetCode_70_ClimbStairs {

    public static int climbStairs(int n) {
        if (n <= 1)return 1;
        else if (n == 2)return 2;

        int one = 1, two = 2, temp= 0;
        for (int i = 3; i <= n; i++) {
            temp = one + two;
            one = two;
            two = temp;
        }

        return temp;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }
}
