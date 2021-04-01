package A_CodePlay.Tag_Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列 中等
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 */
public class LeetCode_46_Permute {

    //回溯算法 模板题
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int[] visited = new int[nums.length];

        backtrack(result, nums, new ArrayList<>(), visited);

        return result;
    }

    private static void backtrack(List<List<Integer>> result, int[] nums, ArrayList<Integer> list, int[] visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));  //我们需要的是其中的在某个特定时期的内容，所以一定要进行拷贝。
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            list.add(nums[i]);
            backtrack(result, nums, list, visited);
            visited[i] = 0;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(permute(a));
    }
}
