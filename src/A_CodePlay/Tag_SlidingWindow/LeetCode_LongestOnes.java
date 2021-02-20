package A_CodePlay.Tag_SlidingWindow;

/**
 * 1004. 最大连续1的个数 III 中等
 *
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 */

public class LeetCode_LongestOnes {

    public int longestOnesI(int[] A, int K) {
        int res = 0;
        int windowL = 0, windowR = 0;
        while (windowR < A.length) {
            if (A[windowR] == 0) {
                if (K == 0) {
                    while (A[windowL] == 1) {
                        windowL++;
                    }
                    windowL++;
                } else {
                    K--;
                }
            }
            windowR++;
            res = Math.max(res, windowR - windowL);
        }
        return res;
    }

    /**
     * 固定一个左端点，K随窗口增大是单调变化的。据此我们可以推知长度为n的窗口如若已经”透支“（K < 0）了，那么长度大于n的也一定不符合条件；
     * K的变化与数组元素有简单的算术关系。向窗口纳入（A[r++]）或移除（A[l++]）一个数组元素，可以在O(1)内更新K。
     */
    public int longestOnesII(int[] A, int K) {
        int L = 0, R = 0, res = 0;
        while (R < A.length) {
            if (A[R] == 0) {
                K--;
            }
            if (K < 0) {
                if (A[L] == 0) {
                    K++;
                }
                L++;
            }
            R++;
            System.out.println(R + " && " + L + "->" + K);
            res = Math.max(res, R - L);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        LeetCode_LongestOnes l = new LeetCode_LongestOnes();
        System.out.println(l.longestOnesII(A, 3));
    }
}
