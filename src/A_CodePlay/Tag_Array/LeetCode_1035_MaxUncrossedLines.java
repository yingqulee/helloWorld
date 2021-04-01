package A_CodePlay.Tag_Array;

/**
 * 1035. 不相交的线 中等
 * 我们在两条独立的水平线上按给定的顺序写下 A 和 B 中的整数。
 *
 * 现在，我们可以绘制一些连接两个数字 A[i] 和 B[j] 的直线，只要 A[i] == B[j]，且我们绘制的直线不与任何其他连线（非水平线）相交。
 *
 * 以这种方法绘制线条，并返回我们可以绘制的最大连线数。
 *
 * 输入：A = [2,5,1,2,5], B = [10,5,2,1,5,2]
 * 输出：3
 *
 * 输入：A = [1,3,7,1,7,5], B = [1,9,2,5,1]
 * 输出：2
 */
public class LeetCode_1035_MaxUncrossedLines {

    public static int maxUncrossedLines(int[] A, int[] B) {
        int M = A.length, N = B.length;
        int[][] ans = new int[M+1][N+1];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i] == B[j]) {
                    ans[i + 1][j + 1] = ans[i][j] + 1;
                } else {
                    ans[i+1][j+1] = Math.max(ans[i+1][j],ans[i][j+1]);
                }
            }
        }
        return ans[M][N];
    }

    public static void main(String[] args) {
        int[] A = {2,5,1,2,5};
        int[] B = {10,5,2,1,5,2};
        System.out.println(maxUncrossedLines(A,B));
    }
}
