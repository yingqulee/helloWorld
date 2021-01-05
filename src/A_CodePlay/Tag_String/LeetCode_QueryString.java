package A_CodePlay.Tag_String;

/**
 * 1016. 子串能表示从 1 到 N 数字的二进制串 中等
 *
 * 给定一个二进制字符串 S（一个仅由若干 '0' 和 '1' 构成的字符串）和一个正整数 N，
 * 如果对于从 1 到 N 的每个整数 X，其二进制表示都是 S 的子串，就返回 true，否则返回 false。
 *
 * 示例 1：
 *
 * 输入：S = "0110", N = 3
 * 输出：true
 * 示例 2：
 *
 * 输入：S = "0110", N = 4
 * 输出：false
 */
public class LeetCode_QueryString {

    public static boolean queryString(String S, int N) {
        int m = (N % 2) + 1; //一部分是冗余的，只匹配N 到 (N>>1)+1，就可以，剩下的都已经包含在这里面了。
        for (int i = m; i <= N; i++) {
            String s = Integer.toBinaryString(i);
            if (!S.contains(s)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "0110";
        System.out.println(queryString(str,3));
    }
}
