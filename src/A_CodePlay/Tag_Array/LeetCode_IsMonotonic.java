package A_CodePlay.Tag_Array;

/**
 * 896. 单调数列 简单
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,2,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：[6,5,4,4]
 * 输出：true
 * 示例 3：
 *
 * 输入：[1,3,2]
 * 输出：false
 * 示例 4：
 *
 * 输入：[1,2,4,5]
 * 输出：true
 * 示例 5：
 *
 * 输入：[1,1,1]
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotonic-array
 */
public class LeetCode_IsMonotonic {

    public boolean isMonotonicI(int[] A) {
        boolean isDecrease = true;
        boolean isIncrease = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                isDecrease = false;
            }
            if (A[i] > A[i - 1]) {
                isIncrease = false;
            }
        }
        return isIncrease || isDecrease;
    }

    public static void main(String[] args) {
        int[] A = {1,2,4,5};
        LeetCode_IsMonotonic l = new LeetCode_IsMonotonic();
        System.out.println(l.isMonotonicI(A));
    }
}
