package A_CodePlay.Tag_Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III 中等
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class LeetCode_CombinationSum3 {

    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> combinationSum3(int k, int n) {
        combination(new ArrayList<Integer>(), k, n, 1);
        return ans;
    }

    private static void combination(List<Integer> tmp, int k,  int n, int start) {
        //剪枝
        if (tmp.size() > k) {
            return;
        }
        if (tmp.size() == k && n == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i <= 9; i++) {
            //剪枝
            if (n - i >= 0) {
                tmp.add(i);
                System.out.println(tmp);
                combination(tmp, k, n - i, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3,9));
    }
}
