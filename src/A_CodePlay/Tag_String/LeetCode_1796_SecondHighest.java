package A_CodePlay.Tag_String;

/**
 * 1796. 字符串中第二大的数字 简单
 *
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
 *
 * 混合字符串 由小写英文字母和数字组成。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "dfa12321afd"
 * 输出：2
 * 解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
 * 示例 2：
 *
 * 输入：s = "abc1111"
 * 输出：-1
 * 解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-largest-digit-in-a-string
 */
public class LeetCode_1796_SecondHighest {

    public int secondHighest(String s) {
        char[] chars = s.toCharArray();
        int max1 = -1, max2 = -1;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                int cur = chars[i] - '0';
                if (cur > max1) {
                    max2 = max1;
                    max1 = cur;
                } else if (cur < max1 && cur > max2) {
                    max2 = cur;
                }
            }
        }
        return max2;
    }

    public static void main(String[] args) {
        LeetCode_1796_SecondHighest l = new LeetCode_1796_SecondHighest();
        System.out.println(l.secondHighest("dfa12321afd"));
    }
}
