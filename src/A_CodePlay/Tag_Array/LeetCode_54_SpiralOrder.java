package A_CodePlay.Tag_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵 中等
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class LeetCode_54_SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();

        int rowHead = 0, rowTail = matrix.length - 1;
        int colHead = 0, colTail = matrix[0].length - 1;

        while (rowHead <= rowTail && colHead <= colTail) {
            for (int i = colHead; i <= colTail; i++) {
                ans.add(matrix[rowHead][i]);
            }
            for (int i = rowHead + 1; i <= rowTail; i++) {
                ans.add(matrix[i][colTail]);
            }
            if (rowHead != rowTail) {
                for (int i = colTail - 1; i >= colHead; i--) {
                    ans.add(matrix[rowTail][i]);
                }
            }

            if (colHead != colTail) {
                for (int i = rowTail - 1; i > rowHead; i--) {
                    ans.add(matrix[i][colHead]);
                }
            }
            rowHead++;rowTail--;
            colHead++;colTail--;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode_54_SpiralOrder l = new LeetCode_54_SpiralOrder();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(l.spiralOrder(matrix));
    }
}
