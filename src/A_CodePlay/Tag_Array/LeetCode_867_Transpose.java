package A_CodePlay.Tag_Array;

import java.util.Arrays;

/**
 * 867. 转置矩阵 简单
 *
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 *
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/transpose-matrix
 */
public class LeetCode_867_Transpose {

    public int[][] transposeI(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) {
            return new int[][]{};
        }
        int m = matrix.length, n = matrix[0].length;
        if (m == n) { //m==n 减少交换
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < i; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            return matrix;
        }
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = matrix[j][i];
            }
        }
        return res;
    }

    public int[][] transposeII(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m * n; i++) {
            res[i % n][i / n] = matrix[i / n][i % n];
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] matrix = {{2,4,-1},{-10,5,11},{18,-7,6}};
        LeetCode_867_Transpose l = new LeetCode_867_Transpose();
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(l.transposeI(matrix)[i]));
        }
    }
}
