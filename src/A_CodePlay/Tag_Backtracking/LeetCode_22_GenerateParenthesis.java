package A_CodePlay.Tag_Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成 中等
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class LeetCode_22_GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", n, n);
        return res;
    }

    //left 统计“(”的个数，right 统计“)”的个数
    private static void helper(List<String> res, String sub, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sub);
            return;
        }
        if (left > 0) {
            helper(res, sub + "(", left - 1, right);
        }
        if (right > left) {
            helper(res, sub + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        List<String> s = generateParenthesis(3);
        System.out.println(s);
    }
}
