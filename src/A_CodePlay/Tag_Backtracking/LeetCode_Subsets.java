package A_CodePlay.Tag_Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集 中等
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets。
 */
public class LeetCode_Subsets {

    //执行用时：7 ms, 在所有 Java 提交中击败了11.47%的用户.
    //内存消耗：38.8 MB, 在所有 Java 提交中击败了45.15%的用户.
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets_slow(int[] nums) {
        backtrack_slow(nums, 0, new ArrayList<>());
        return res;
    }

    public void backtrack_slow(int[] nums, int start, List<Integer> list) {
        if (!res.contains(new ArrayList<>(list))) { //这个太忙了, 但是易于理解
            res.add(new ArrayList<>(list));
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack_slow(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    //优化
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums, int start, List<Integer> list) {
        for (int i = start; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            temp.add(nums[i]);
            res.add(temp);
            backtrack(nums, i + 1, temp);
        }
    }

    //再次优化 直接遍历，遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
    public static List<List<Integer>> subsetsI(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> list = new ArrayList<>();
            for (List<Integer> num : res) {
                List<Integer> tmp = new ArrayList<>(num);
                tmp.add(nums[i]);
                list.add(tmp);
            }
            res.addAll(list);
        }
        return res;
    }

    //更优的解法--->位运算

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new LeetCode_Subsets().subsetsI(nums));
    }
}
