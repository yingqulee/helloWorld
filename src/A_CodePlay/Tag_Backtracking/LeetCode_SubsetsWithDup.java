package A_CodePlay.Tag_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II 中等
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 */
public class LeetCode_SubsetsWithDup {

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return res;
        }
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    private static void backtrack(int[] nums, int start, List<Integer> tmp) {
        if (start == nums.length + 1) {
            return;
        }
        res.add(new ArrayList<>(tmp));
        int visited = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = start; i < len; i++) {
            if (nums[i] != visited) {
                tmp.add(nums[i]);
                backtrack(nums, i+1, tmp);
                tmp.remove(tmp.size() - 1);
                visited = nums[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
}
