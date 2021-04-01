package A_CodePlay.Tag_TwoPointer;

/**
 * 828. 统计子串中的唯一字符 困难
 *
 * 如果一个字符在字符串 S 中有且仅有出现一次，那么我们称其为独特字符。
 * 例如，在字符串 S = "LETTER" 中，"L" 和 "R" 可以被称为独特字符。
 * 我们再定义 UNIQ(S) 作为字符串 S 中独特字符的个数。
 * 那么，在 S = "LETTER" 中， UNIQ("LETTER") =  2。
 * 对于给定字符串 S，计算其所有非空子串的独特字符的个数（即 UNIQ(substring)）之和。
 * 如果在 S 的不同位置上出现两个甚至多个相同的子串，那么我们认为这些子串是不同的。
 * 考虑到答案可能会非常大，规定返回格式为：结果 mod 10 ^ 9 + 7。
 *
 * 示例 1:
 * 输入: "ABC"
 * 输出: 10
 * 解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
 *      其中，每一个子串都由独特字符构成。
 *      所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10
 *
 * 示例 2:
 * 输入: "ABA"
 * 输出: 8
 * 解释: 除了子串 UNIQ('ABA') = 1，其余与示例1相同。
 */
public class LeetCode_828_UniqueLetterString {
    /**
     * 思路:
     * 对每一个字符i，向前找到相同的字符j，向后找到相同的字符k。当前字符对最终结果的贡献是：（i-j）*(k-i)。
     * 这相当于两种方案的拼接：在字符串A（j到i）当中，字符i贡献的次数是（i-j）次。
     * 在字符串B(k-i)当中，字符i贡献的次数是（k-i）。
     * 那么当两者拼接的时候，字符i对子串（j到k）的贡献就是两种方案的乘积（符合乘法公式）。
     */
    public static int uniqueLetterString(String S) {
        long sum = 0;
        for (int i = 0; i < S.length(); i++) {
            int j = i - 1;
            int k = i + 1;
            while(j > -1 && S.charAt(j) != S.charAt(i)) --j;
            while(k < S.length() && S.charAt(k) != S.charAt(i)) ++k;
            sum += (i - j) * (k - i);
        }

        return (int) (sum % 1000000007);
    }

    public static void main(String[] args) {
        String S = "ABA";
        System.out.println(uniqueLetterString(S));
    }
}
