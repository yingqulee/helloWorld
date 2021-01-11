package A_CodePlay.Tag_SlidingWindow;

import java.util.*;

/**
 * 3. 无重复字符的最长子串 中等
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 */
public class LeetCode_LengthOfLongestSubstring {

    /**
     * 思路:
     * 使用 HashSet 将字符存储在当前窗口 [i, j) 最初 j = i）中。
     * 然后我们向右侧滑动索引 j，如果它不在 HashSet 中，我们会继续滑动 j。
     * 直到 s[j] 已经存在于 HashSet 中。此时，我们找到的没有重复字符的最长子字符串将会以索引 i 开头。
     * 如果我们对所有的 i 这样做，就可以得到答案。
     *
     * 时间复杂度：O(2n) = O(n)，在最糟糕的情况下，每个字符将被 i 和 j 访问两次。
     *
     * 空间复杂度：O(min(m, n))，与之前的方法相同。
     * 滑动窗口法需要 O(k) 的空间，其中 k 表示 Set 的大小。而 Set 的大小取决于字符串 n 的大小以及字符集/字母 m 的大小
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0, i = 0, j = 0;
        while(i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                res = Math.max(res,j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }

    /**
     * 优化后的 滑动窗口
     * 如果 s[j] 在 [i, j) 范围内有与 j′ 重复的字符，我们不需要逐渐增加 i 。
     * 我们可以直接跳过 [i，j′] 范围内的所有元素，并将 i 变为 j' + 1
     */
    public static int lengthOfLongestSubstring02(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i,map.get(s.charAt(j)));
            }
            res = Math.max(res, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
