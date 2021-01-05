package A_CodePlay.Tag_Math;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 剑指 Offer 66. 构建乘积数组 中等
 *
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class NewCoder_Multiply {

    //乘积 = 当前数左边的乘积 * 当前数右边的乘积
    public static int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        int left = 0, cur = 1;
        while (left < n) {
            B[left] = cur; // 先乘左边的数(不包括自己)
            cur *= A[left];
            left++;
        }

        int right = n - 1;
        cur = 1;
        while (right >= 0) {
            B[right] *= cur; // 再乘右边的数(不包括自己)
            cur *= A[right];
            right--;
            //System.out.println(Arrays.toString(B));
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        System.out.println(Arrays.toString(multiply(A)));
    }
}
