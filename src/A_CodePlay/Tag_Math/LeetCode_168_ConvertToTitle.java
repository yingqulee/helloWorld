package A_CodePlay.Tag_Math;

/**
 * 168. Excel表列名称 简单
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 *
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 *
 * 输入: 701
 * 输出: "ZY"
 */
public class LeetCode_168_ConvertToTitle {

    public static String convertToTitle(int n) {

//        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));

        if (n <= 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        while (n --> 0) {
            sb.append((char) (n % 26 + 'A'));
            n = n / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
}
