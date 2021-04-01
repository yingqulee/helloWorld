package A_CodePlay.Tag_DynamicProgramming;

import java.util.Arrays;

/**
 * 300. 最长递增子序列 中等
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class LeetCode_300_LengthOfLIS {

    /**
     * 动态规划: 时间复杂度为O(n^2)
     */
    public int lengthOfLIS_I(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 二分查找: 时间复杂度为O(nlogn)
     */
//    public int lengthOfLIS_II(int[] nums) {
//        int maxLen = 0;
//        int[] res = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int lo = 0, hi = maxLen;
//
//            while(lo < hi) {
//                int mid = lo + (hi - lo) / 2;
//                if(res[mid] < nums[i]) {
//                    lo = mid + 1;
//                } else {
//                    hi = mid;
//                }
//            }
//            res[lo] = nums[i];
//            if(lo == maxLen) {
//                maxLen++;
//            }
//        }
//        return maxLen;
//    }

    public static void main(String[] args) {

    }
}
