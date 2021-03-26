package A_CodePlay.Tag_Array;

/**
 * 1800. 最大升序子数组和 简单
 * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 *
 * 子数组是数组中的一个连续数字序列。
 *
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [10,20,30,5,10,50]
 * 输出：65
 * 解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
 * 示例 2：
 *
 * 输入：nums = [10,20,30,40,50]
 * 输出：150
 * 解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。
 * 示例 3：
 *
 * 输入：nums = [12,17,15,13,10,11,12]
 * 输出：33
 * 解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。
 * 示例 4：
 *
 * 输入：nums = [100,10,1]
 * 输出：100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-ascending-subarray-sum
 */
public class LeetCode_MaxAscendingSum {

    public int maxAscendingSumI(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0, end = 0;
        int res = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] <= nums[i]) {
                start = i + 1;
                end = i + 1;
            } else {
                end++;
            }
            res = Math.max(res, sum(start, end, nums));
        }
        return res;
    }

    public int sum(int start, int end, int[] nums) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    //优化
    public int maxAscendingSumII(int[] nums) {
        int res = 0, sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                res = Math.max(res, sum);
                sum = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_MaxAscendingSum l = new LeetCode_MaxAscendingSum();
        int[] nums = {3,6,10,1,8,9,9,8,9};
        System.out.println(l.maxAscendingSumII(nums));
    }
}
