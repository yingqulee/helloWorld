package A_CodePlay.Tag_BitManipulation;

import java.util.Arrays;

/**
 * 268. 丢失的数字 简单
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 */
public class LeetCode_268_MissingNumber {

    /**
     * 0 ^ 4 = 4
     * 4 ^ 4 = 0
     * 那么，就可以不用求和，直接使用异或运算^进行 抵消，剩下的数字就是缺失的了。
     */
    public static int missingNumber(int[] nums) {
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i] ^ i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,6,7};
        System.out.println(missingNumber(nums));
    }
}
