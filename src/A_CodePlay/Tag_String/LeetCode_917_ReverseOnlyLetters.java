package A_CodePlay.Tag_String;

/**
 * 917. 仅仅反转字母 简单
 *
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S 中不包含 \ or "
 */
public class LeetCode_917_ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() <= 0) {
            return S;
        }
        char[] chars = S.toCharArray();
        int l = 0, r = S.length() - 1;
        while (l < r) {
            while ( l < r && !Character.isLetter(chars[l])) {
                l++;
            }
            while ( l < r && !Character.isLetter(chars[r])) {
                r--;
            }
            char c = chars[l];
            chars[l++] = chars[r];
            chars[r--] = c;
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        LeetCode_917_ReverseOnlyLetters l = new LeetCode_917_ReverseOnlyLetters();
        System.out.println(l.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
