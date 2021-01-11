package A_CodePlay.Tag_BFSAndDFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合 中等
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 *   1   2abc 3def
 * 4ghi  5jkl 6mno
 * 7pqrs 8tuv 9wxyz
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LeetCode_LetterCombinations {

    private final String[] PHONE = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private List<String> res;

    //dfs
    public List<String> letterCombinationsI(String digits) {
        res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        dfs("", digits, 0);
        return res;
    }

    public void dfs(String str, String digits, int index) {
        if (index >= digits.length()) {
            res.add(str);
            return;
        }
        String letter = PHONE[digits.charAt(index) - '0'];
        for (char c : letter.toCharArray()) {
            dfs(str + c, digits, index + 1);
        }
    }

    //回溯算法
    private StringBuilder path = new StringBuilder();

    public List<String> letterCombinationsII(String digits) {
        res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        backtrack(digits, 0);
        return res;
    }
    private void backtrack(String digits, int index) {
        if (path.length() == digits.length()) {
            res.add(path.toString());
            return;
        }
        String letter = PHONE[digits.charAt(index) - '0'];
        for (char ch : letter.toCharArray()) {
            path.append(ch);
            backtrack(digits,index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        LeetCode_LetterCombinations l =  new LeetCode_LetterCombinations();
        System.out.println(l.letterCombinationsII(digits));
    }
}
