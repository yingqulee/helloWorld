package A_CodePlay.Tag_DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 120. 三角形最小路径和 中等
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class LeetCode_MinimumToatal {

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // 只需要记录每一层的最小值即可
        int[] min = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                //这里的min[j] 使用的时候默认是上一层的，赋值之后变成当前层
                min[j] = triangle.get(i).get(j) + Math.min(min[j], min[j + 1]);
//                System.out.println(min[j]);
            }
        }
        return min[0];
    }

    public static void main(String[] args) {
//        List<Integer> zero = new ArrayList<>();
//        Collections.addAll(zero,2);
//
//        List<Integer> one = new ArrayList<>();
//        Collections.addAll(one,3,4);
//
//        List<Integer> two = new ArrayList<>();
//        Collections.addAll(two,6,5,7);
//
//        List<Integer> three = new ArrayList<>();
//        Collections.addAll(three,4,1,8,3);
//
//        Collections.addAll(triangle,zero,one,two,three);
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );
        System.out.println(minimumTotal(triangle));

    }
}
