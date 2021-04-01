package A_CodePlay.Tag_DynamicProgramming;

/**
 * 152. 乘积最大子数组 中等
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class LeetCode_152_MaxProduct {

    public static int maxProductI(int[] nums) {
        if (nums.length <=0) {
            return 0;
        }

        //一个保存最大的，一个保存最小的。
        int max = Integer.MIN_VALUE, maxCur = 1, minCur = 1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) { //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
                int tmp = maxCur;
                maxCur = minCur;
                minCur = tmp;
            }
            maxCur = Math.max(maxCur*nums[i], nums[i]);
            minCur = Math.min(minCur*nums[i], nums[i]);
            max = Math.max(maxCur, max);
        }
        return max;
    }

    public static int maxProductII(int[] nums) {
        if (nums.length <=0) {
            return 0;
        }
        int[] curMax = new int[nums.length];
        int[] curMin = new int[nums.length];
        curMax[0] = curMin[0] = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curMax[i] = Math.max(nums[i], Math.max(curMax[i-1] * nums[i], curMin[i-1] * nums[i]));
            System.out.print(curMax[i] + " ");
            curMin[i] = Math.min(nums[i], Math.min(curMax[i-1] * nums[i], curMin[i-1] * nums[i]));
            System.out.println(curMin[i]);
            res = curMax[i] > res ? curMax[i] : res;
        }

        return res;
    }

    public static int maxProductIII(int[] nums) {
        if (nums.length <=0) {
            return 0;
        }
        int curMax = nums[0], curMin = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = curMax, min = curMin;
            curMax = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            curMin = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));
            res = curMax > res ? curMax : res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-3,-2};
        System.out.println(maxProductIII(nums));
    }
}

