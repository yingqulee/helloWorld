package A_CodePlay.Tag_Array;

import java.util.ArrayList;

/**
 * 剑指 Offer 29. 顺时针打印矩阵 简单
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 */
public class NewCoder_PrintMatrix {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();

        int rowHead = 0, rowTail = matrix.length - 1;
        int colHead = 0, colTail = matrix[0].length - 1;

        while(rowHead <= rowTail && colHead <= colTail){
            for (int i = colHead; i <= colTail; i++)
                ans.add(matrix[rowHead][i]);

            for (int i = rowHead + 1; i <= rowTail; i++)
                ans.add(matrix[i][colTail]);

            if (rowHead != rowTail)
                for (int i = colTail - 1; i >= colHead; i--)
                    ans.add(matrix[rowTail][i]);

            if (colHead != colTail)
                for (int i = rowTail - 1; i > rowHead; i--)
                    ans.add(matrix[i][colHead]);

            rowHead++;rowTail--;
            colHead++;colTail--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(printMatrix(matrix));
    }
}
