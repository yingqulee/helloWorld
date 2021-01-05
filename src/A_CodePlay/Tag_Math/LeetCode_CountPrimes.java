package A_CodePlay.Tag_Math;

import java.util.Arrays;

/** 204. 计数质数 简单
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class LeetCode_CountPrimes {

    public static int countPrimes(int n) {
        /**
         * 思路:厄拉多塞筛法
         * 先将 2~n 的各个数放入表中，然后在2的上面画一个圆圈，然后划去2的其他倍数；
         * 第一个既未画圈又没有被划去的数是3，将它画圈，再划去3的其他倍数；
         * 现在既未画圈又没有被划去的第一个数 是5，将它画圈，并划去5的其他倍数……依次类推，
         * 一直到所有小于或等于 n 的各数都画了圈或划去为止。这时，表中画了圈的以及未划去的那些数正好就是小于 n 的素数
         */
        if (n <= 2)return 0;
        int count = 0;

        boolean[] temp = new boolean[n];
        Arrays.fill(temp,true);
        for (int i = 2; i < n; i++) {
            if (temp[i]) {
                count++;
                for (int j = i + i; j < n; j += i) {
                    temp[j] = false;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
