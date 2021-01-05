package A_CodePlay.Tag_BitManipulation;

/**
 * 231. 2的幂 简单
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 */
public class LeetCode_IsPowerOfTwo {
    /**
     * 思路:
     * 如果一个数是 2 的次方数的话，那么它的二进数必然是最高位为1，其它都为 0 ，
     * 那么如果此时我们减 1 的话，则最高位会降一位，其余为 0 的位现在都为变为 1，那么我们把两数相与，就会得到 0。
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        return  n > 0 && (n & n - 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }
}
