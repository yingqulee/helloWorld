package A_CodePlay.Tag_BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_78_Subsets {
    /**
     * 78. 子集 中等
     *
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     *
     * 说明：解集不能包含重复的子集。
     *
     * 示例:
     *
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */

    /**
     * 思路:
     * 直接遍历，遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
     *
     */
    public static List<List<Integer>> subsetI01(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for(int i = 0; i < nums.length; i++) {

            List<List<Integer>> plusNumbers = new ArrayList<>();
            for(List<Integer> num : ans) {
                List<Integer> newNumber = new ArrayList<>(num);
                newNumber.add(nums[i]);
                plusNumbers.add(newNumber);
            }
            ans.addAll(plusNumbers);
        }
        return ans;
    }

    /**
     * 思路: 位运算
     * 数组的每个元素，可以有两个状态：1、不在子数组中（用 0 表示）；2、在子数组中（用 1 表示）。
     * 从 0 到 2 的数组个数次幂（不包括）的整数的二进制表示就能表示所有状态的组合。
     */
    public static List<List<Integer>> subsetI02(int[] nums) {
        int len = nums.length;
        int n = 1 << len;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> cur = new ArrayList<>();

            for (int j = 0; j < len; j++) {
                if (((i >> j) & 1) == 1) {
                    cur.add(nums[j]);
                }
            }
            ans.add(cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsetI02(nums));
    }
}
