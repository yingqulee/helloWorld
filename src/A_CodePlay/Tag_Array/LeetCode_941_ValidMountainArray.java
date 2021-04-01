package A_CodePlay.Tag_Array;

/**
 * 941. 有效的山脉数组 简单
 *
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[B.length - 1]
 *
 *
 * 示例 1：
 *
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 *
 * 输入：[0,3,2,1]
 * 输出：true
 */
public class LeetCode_941_ValidMountainArray {

    public static boolean validMountainArray(int[] A) {

        /*if (A.length < 3) return false;
        int i = 1;

        while(i < A.length && A[i-1] < A[i])i++;
        if (i >= A.length || A[i] == A[i-1])return false;

        while(i < A.length - 1 && A[i] > A[i+1])i++;
        if (i >= A.length - 1 && A[0] < A[1])return true;

        return false;*/

        int mid = 0;        // 记录山脉的顶点
        int len = A.length; // 数组长度

        // 山脉的条件1：A.length >= 3
        if (len < 3) {
            return false;
        }

        // 山脉的顶点不能在第一个
        // 山脉的条件2:A[0] < A[1] < ... A[i-1] < A[i]
        if (A[0] > A[1]) {
            return false;
        }

        // 找出顶点所在的位置
        for (int i = 1; i < len-1; i++) {
            if (A[i] > A[i+1]) {
                mid = i;
                break;
            }
        }

        // 山脉的条件3:A[i] > A[i+1] > ... > A[B.length - 1]
        for (int j = mid; j<len-1; j++) {
            if (A[j] <= A[j+1])
                return false;
        }

        // 所有条件都满足了
        return true;
    }

    public static void main(String[] args) {
        int[] a = {0,3,2,1};
        System.out.println(validMountainArray(a));
    }
}
