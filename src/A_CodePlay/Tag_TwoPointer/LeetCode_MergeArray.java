package A_CodePlay.Tag_TwoPointer;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组 简单
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class LeetCode_MergeArray {

    //最朴素的解法就是将两个数组合并之后再排序。
    // 时间复杂度较差，为O((n + m)log(n + m))。这是由于这种方法没有利用两个数组本身已经有序这一点。
    public static void merge01(int[] nums1, int m, int[] nums2, int n) {

        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    //双指针: 从后往前
    public static void merge02(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;

        //指针 p 用于追踪添加元素的位置
        int p = m + n - 1;

        while((p1 >= 0) && (p2 >= 0)){
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        //第一轮循环合并完后，由于可能nums2指针未走完，需要将nums2剩余首部覆盖至nums1首部。
        // nums1指针未走完不需要做任何多余操作，因为覆盖前后相同
        System.arraycopy(nums2,0,nums1,0,p2 + 1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,0,0,0};
        int[] b = {2,5,6};
        merge02(a,3,b,3);
    }
}
