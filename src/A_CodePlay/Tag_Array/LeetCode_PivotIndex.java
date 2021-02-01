package A_CodePlay.Tag_Array;

import java.util.Arrays;

/**
 *  724. 寻找数组的中心索引 简单
 *  给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 *
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。 
 *
 * 示例 1：
 *
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2：
 *
 * 输入：
 * nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心索引。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-pivot-index
 */
public class LeetCode_PivotIndex {

    public int pivotIndexI(int[] nums) {
        int[] pre = new int[nums.length + 1];
        int n = pre.length;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1] + nums[i-1];
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(pre));
        for (int i = 1; i < n; i++) {
            if (pre[i-1] == pre[n-1] - pre[i]) {
                return i - 1;
            }
        }
        return -1;
    }

    //当前的和*2+中心索引的值就是整个数组的和
    public int pivotIndexII(int[] nums) {
        int sum = 0, leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum * 2 + nums[i] == sum) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        LeetCode_PivotIndex l = new LeetCode_PivotIndex();
        System.out.println(l.pivotIndexII(nums));
    }
}
