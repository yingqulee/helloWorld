package A_CodePlay.Tag_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class LeetCode_119_GetRow {

    /*public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int i = 1; i <= 33; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = triangle.get(i-1);

            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(preRow.get(j-1) + preRow.get(j));
            }
            row.add(1);

            triangle.add(row);
        }

        return triangle.get(rowIndex);
    }*/

    /**
     * 获取杨辉三角的指定行
     * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
     * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>(rowIndex + 1);
        long current = 1;

        for (int i = 0; i <= rowIndex; i++) {
            ans.add((int) current);
            current = current * (rowIndex-i)/(i+1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int rowIndex = 33;
        System.out.println(getRow(rowIndex));
    }
}
