package A_LeetCodeContest;

/**
 * 给你一个字符串 S，请你删去其中的所有元音字母（ 'a'，'e'，'i'，'o'，'u'），并返回这个新字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入："leetcodeisacommunityforcoders"
 * 输出："ltcdscmmntyfrcdrs"
 * 示例 2：
 *
 * 输入："aeiou"
 * 输出：""
 */
public class Contest_RemoveVowels {

    public static String removeVowels(String S) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != 'a' && S.charAt(i) != 'e' && S.charAt(i) != 'i'&&
                    S.charAt(i) != 'o' && S.charAt(i) != 'u'){
                ans.append(S.charAt(i));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeVowels("leetcodeisacommunityforcoders"));
    }
}

