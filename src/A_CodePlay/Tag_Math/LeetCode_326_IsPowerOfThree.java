package A_CodePlay.Tag_Math;

/**
 * 326. 3的幂 简单
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
public class LeetCode_326_IsPowerOfThree {
    /**
     * 思路:
     * 这里取巧的方法 用到了数论的知识：3 的幂次的质因子只有 3。
     *
     * 题目要求输入的是 int 类型，正数范围是 0 - 2^31，在此范围中
     * 允许的最大的 3 的次方数为 3^19 = 1162261467 ，那么只要看这个数能否被 n 整除即可
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(9));
    }
}
