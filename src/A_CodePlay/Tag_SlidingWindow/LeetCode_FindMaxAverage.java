package A_CodePlay.Tag_SlidingWindow;

/**
 *  643. 子数组最大平均数 I 简单
 *  给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 */
public class LeetCode_FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += nums[i];
        }
        if (nums.length == k) {
            return (double)max / k;
        }
        int tmp = max;
        //滑动窗口
        for (int i = k; i < nums.length; i++) {
            tmp = tmp + nums[i] - nums[i - k];
            max = Math.max(tmp, max);
        }
        return (double)max / k;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        LeetCode_FindMaxAverage leetCode_findMaxAverage = new LeetCode_FindMaxAverage();
        System.out.println(leetCode_findMaxAverage.findMaxAverage(nums, 4));
    }
}
