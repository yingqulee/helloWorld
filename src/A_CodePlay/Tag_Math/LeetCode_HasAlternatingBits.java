package A_CodePlay.Tag_Math;

/**
 * 693. 交替位二进制数 简单
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111.
 * 示例 3：
 *
 * 输入：n = 11
 * 输出：false
 * 解释：11 的二进制表示是：1011.
 * 示例 4：
 *
 * 输入：n = 10
 * 输出：true
 * 解释：10 的二进制表示是：1010.
 * 示例 5：
 *
 * 输入：n = 3
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-number-with-alternating-bits
 */
public class LeetCode_HasAlternatingBits {

    public boolean hasAlternatingBitsI(int n) {
        int num = n ^ (n >> 1);
        return (num & (num + 1)) == 0;
    }

    //转化为字符串
    public boolean hasAlternatingBitsII(int n) {
        char[] chars = Integer.toBinaryString(n).toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_HasAlternatingBits l = new LeetCode_HasAlternatingBits();
        System.out.println(l.hasAlternatingBitsII(10));
    }
}
