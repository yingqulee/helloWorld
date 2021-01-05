package A_LeetCodeContest;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个 非递减 的正整数数组 nums 和整数 K，判断该数组是否可以被分成一个或几个 长度至少 为 K 的 不相交的递增子序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,3,3,4,4], K = 3
 * 输出：true
 * 解释：
 * 该数组可以分成两个子序列 [1,2,3,4] 和 [2,3,4]，每个子序列的长度都至少是 3。
 * 示例 2：
 *
 * 输入：nums = [5,6,6,7,8], K = 3
 * 输出：false
 * 解释：
 * 没有办法根据条件来划分数组。
 */
public class Contest_CanDivideIntoSubsequences {

    public static boolean canDivideIntoSubsequences01(int[] nums, int K) {
         Map<Integer,Integer> ans = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (ans.containsKey(nums[i]))
                ans.put(nums[i],ans.get(nums[i])+1);
            else ans.put(nums[i],1);
        }
        int max = 0;
        for (int key : ans.keySet()) {
            max = Math.max(max,ans.get(key));
        }
        return nums.length >= K * max;
    }

    public static boolean canDivideIntoSubsequences02(int[] nums, int K) {
        /**
         * 思路:
         * 因为相同的数不能在同一个数组,最大相同的数有几个;
         */
        Map<Integer,Integer> count = new HashMap<>();//计数器
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i],count.getOrDefault(nums[i],0) + 1);
            max = Math.max(max,count.get(nums[i]));
        }
        return nums.length >= K * max;
    }

    public static void main(String[] args) {
        int[] nums = {5,6,6,7,8};
        System.out.println(canDivideIntoSubsequences01(nums,3));
    }
}
