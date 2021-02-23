package A_CodePlay.Tag_SlidingWindow;

import java.util.Arrays;

/**
 * 1052. 爱生气的书店老板 中等
 *
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 *
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 * 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 *
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *  
 *
 * 示例：
 *
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
 */
public class LeetCode_MaxSatisfied {

    /**
     * 首先 找到不改变的时候客人就满意的数量和 同时更新数组
     * 这样问题就转变为 求数组指定长度最大和的问题
     * 时间复杂度 O(n) 空间复杂度为O（1）
     */
    public int maxSatisfiedI(int[] customers, int[] grumpy, int X) {
        int res = 0;
        int len = customers.length;
        System.out.println(Arrays.toString(customers));
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
                customers[i] = 0;
            }
        }
        System.out.println(Arrays.toString(customers));
        int sum = 0, max = 0;
        for (int i = 0; i < X; i++) {
            sum += customers[i];
        }
        max = sum;
        for (int i = X; i < len; i++) {
            sum += customers[i];
            sum -= customers[i - X];
            max = Math.max(max, sum);
        }
        return res + max;
    }

    public int maxSatisfiedII(int[] customers, int[] grumpy, int X) {
        int res = 0;
        int sum = 0, max = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
                customers[i] = 0;
            }
            sum += customers[i] - (i < X ? 0 : customers[i - X]);
            max = Math.max(sum, max);
        }
        return res + max;
    }

    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        LeetCode_MaxSatisfied l = new LeetCode_MaxSatisfied();
        System.out.println(l.maxSatisfiedII(customers, grumpy, 3));
    }
}
