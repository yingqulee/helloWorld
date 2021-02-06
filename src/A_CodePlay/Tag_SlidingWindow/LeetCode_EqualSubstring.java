package A_CodePlay.Tag_SlidingWindow;

/**
 * 1208. 尽可能使字符串相等 中等
 * 给你两个长度相同的字符串，s 和 t。
 *
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 *
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 *
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 *
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "bcdf", cost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 * 示例 2：
 *
 * 输入：s = "abcd", t = "cdef", cost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 * 示例 3：
 *
 * 输入：s = "abcd", t = "acde", cost = 0
 * 输出：1
 * 解释：你无法作出任何改动，所以最大长度为 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-equal-substrings-within-budget
 */
public class LeetCode_EqualSubstring {

    public int equalSubstringI(String s, String t, int maxCost) {
        int left = 0, max = 0;
        int cost = 0;
        for (int i = 0; i < s.length(); i++) {
            cost += Math.abs(s.charAt(i) - t.charAt(i));
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public int equalSubstringII(String s, String t, int maxCost) {
        int left = 0, right = 0;
        int cost = 0;
        while (right < s.length()) {
            cost += Math.abs(s.charAt(right) - t.charAt(right));
            right++;
            if (cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
        }
        return s.length() - left;
    }

    //简单理解
    public int equalSubstringIII(String s, String t, int maxCost) {
        int left = 0, right = 0, len = s.length();
        int [] distance = new int[len];
        int cost = 0, max = 0;
        for (int i = 0; i < len; i++) {
            distance[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        while (right < len) {
            cost = cost + distance[right];
            right++;
            while (cost>maxCost) {
                cost -= distance[left];
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode_EqualSubstring leetCode_equalSubstring = new LeetCode_EqualSubstring();
        System.out.println(leetCode_equalSubstring.equalSubstringII("abcd","bcdf",3));
    }
}
