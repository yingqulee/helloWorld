package A_CodePlay.Tag_SlidingWindow;

/**
 * 424. 替换后的最长重复字符 中等
 *
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意：字符串长度 和 k 不会超过 104。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 *
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 */
public class LeetCode_424_CharacterReplacement {

    //维护窗口使用j-i+1-count
    public int characterReplacement(String s, int k) {
        int L = 0, R = 0, res = 0, max = 0;
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        while (R < chars.length) {
            count[chars[R] - 'A']++;
            max = Math.max(max, count[chars[R] - 'A']);
            if ((R - L + 1 - max) > k) {
                count[chars[L++] - 'A']--;
            }
            R++;
        }
        return R - L;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        LeetCode_424_CharacterReplacement l = new LeetCode_424_CharacterReplacement();
        System.out.println(l.characterReplacement(s, 2));
    }
}
