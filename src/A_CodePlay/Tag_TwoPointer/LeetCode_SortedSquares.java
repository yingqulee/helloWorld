package A_CodePlay.Tag_TwoPointer;

import java.util.Arrays;

/**
 * 977. 有序数组的平方 简单
 *
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * 提示：
 * <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序
 */
public class LeetCode_SortedSquares {
    /**
     * 思路:排序
     */
    public static int[] sortedSquares01(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; ++i)
            ans[i] = A[i] * A[i];

        Arrays.sort(ans);
        return ans;
    }

    /**
     * 思路:双指针
     * 因为数组 A 已经排好序了， 所以可以说数组中的负数已经按照平方值降序排好了，数组中的非负数已经按照平方值升序排好了。
     * 使用两个指针分别读取数组的非负部分与负数部分 —— 指针 i 反向读取负数部分，指针 j 正向读取非负数部分。
     * 使用两个指针分别读取两个递增的数组了（按元素的平方排序）。接下来，使用双指针的技巧合并这两个数组。
     */
    public static int[] sortedSquares02(int[] A) {
        int N = A.length;
        int j = 0;
        while (j < N && A[j] < 0) {
            j++;
        }
        int i = j-1;

        int[] ans = new int[N];
        int t = 0;

        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares02(A)));
    }
}
