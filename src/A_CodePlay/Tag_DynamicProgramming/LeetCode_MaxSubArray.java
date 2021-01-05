package A_CodePlay.Tag_DynamicProgramming;

/**
 * 53. 最大子序和 简单
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class LeetCode_MaxSubArray {

    /**
     * 动态规划
     *
     * 动态规划的是首先对数组进行遍历，当前最大连续子序列和为 currentSum，结果为 max
     * 如果 currentSum > 0，则说明 currentSum 对结果有增益效果，则 currentSum 保留并加上当前遍历数字
     * 如果 currentSum <= 0，则说明 currentSum 对结果无增益效果，需要舍弃，则 currentSum 直接更新为当前遍历数字
     * 每次比较 currentSum 和 max 的大小，将最大值置为 max，遍历结束返回结果
     * 时间复杂度：O(n)
     *
     * @param nums
     * @return max
     */
    public static int maxSubArray(int[] nums) {

        int currentSum = 0, max = nums[0];
        for (int i : nums) {
            if(currentSum > 0) {
                currentSum += i;
            } else {
                currentSum = i;
            }
            max = Math.max(max, currentSum);
        }
        return max;
    }

    //分治法

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(a);
        System.out.println(result);
    }
}
