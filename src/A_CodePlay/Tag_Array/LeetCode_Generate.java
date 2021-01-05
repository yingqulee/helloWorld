package A_CodePlay.Tag_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角 简单
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class LeetCode_Generate {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) return triangle;

        //第一行总是1
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = triangle.get(i-1);

            //每行的第一个元素总是1
            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(preRow.get(j-1) + preRow.get(j));
            }

            //每行的最后一个元素总是1
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> list = generate(numRows);
        System.out.println(list);
    }
}
