package A_LeetCodeContest;

import java.util.Arrays;
import java.util.LinkedList;

/**5190. 反转每对括号间的子串
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 * 示例 1：
 *
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 *
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 *
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 *
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 */
public class Contest_ReverseParentheses {

    static int idx = 0, len;
    public static String reverseParentheses(String s) {
        len = s.length();
        return solve(s);
    }

    private static String solve(String s) {
        StringBuilder sb = new StringBuilder();
        while (idx < len) {
            if (s.charAt(idx) == '(') {
                ++idx;
                sb.append(solve(s));
            } else if (s.charAt(idx) == ')') {
                ++idx;
                return sb.reverse().toString();
            } else {
                sb.append(s.charAt(idx));
                ++idx;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "edetocel";
        System.out.println(reverseParentheses(s));
    }
}
