package A_CodePlay.Tag_Math;

/**
 * 263. 丑数 简单
 *
 * 编写一个程序判断给定的数是否为丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例 1:
 *
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 * 示例 2:
 *
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 * 示例 3:
 *
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 *
 * 链接：https://leetcode-cn.com/problems/ugly-number
 */
public class LeetCode_IsUgly {

    //对能被2,3,5整除的数不断除2,3,5，最后剩1就是，剩0就不是，除2可以用位运算替换
    public static boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while ((num & 1) == 0) {
            num >>= 1;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(6));
    }
}
