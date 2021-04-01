package A_CodePlay.Tag_Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串 中等
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 */
public class LeetCode_131_Partition {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(new ArrayList<>(), s, 0);
        return res;
    }

    public void backtrack(List<String> path, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String subStr = s.substring(start, i + 1);
            if (!isPalindrome(subStr)) {
                continue;
            }
            path.add(subStr);
            backtrack(path, s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 1 || s == null) {
            return true;
        }
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;end--;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_131_Partition l = new LeetCode_131_Partition();
        System.out.println(l.partition("aab"));
    }
}
