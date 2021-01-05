package A_LeetCodeContest;

import java.util.*;

/**5070. 与目标颜色间的最短距离
 * 给你一个数组 colors，里面有  1、2、 3 三种颜色。
 *
 * 我们需要在 colors 上进行一些查询操作 queries，其中每个待查项都由两个整数 i 和 c 组成。
 *
 * 现在请你帮忙设计一个算法，查找从索引 i 到具有目标颜色 c 的元素之间的最短距离。
 *
 * 如果不存在解决方案，请返回 -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
 * 输出：[3,0,3]
 * 解释：
 * 距离索引 1 最近的颜色 3 位于索引 4（距离为 3）。
 * 距离索引 2 最近的颜色 2 就是它自己（距离为 0）。
 * 距离索引 6 最近的颜色 1 位于索引 3（距离为 3）。
 * 示例 2：
 *
 * 输入：colors = [1,2], queries = [[0,3]]
 * 输出：[-1]
 * 解释：colors 中没有颜色 3。
 */
public class Contest_ShortestDistanceColor {

    public static List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int[] cts = new int[4];
        int n = colors.length;
        for (int c : colors) {
            cts[c]++;
        }
        ArrayList<ArrayList<Integer>> cls = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            cls.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            cls.get(colors[i]).add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int i = q[0];
            int c = q[1];
            int pos = Collections.binarySearch(cls.get(c), i);
            if (pos>=0) {
                ans.add(0);
            } else {
                pos++;
                pos = -pos;
                int ta = 1000000000;
                if (pos > 0)
                    ta = i-cls.get(c).get(pos-1);
                if (pos < cls.get(c).size())
                    ta = Math.min(ta, cls.get(c).get(pos)-i);
                ans.add(ta==1000000000?-1:ta);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] colors = {1,1,2,1,3,2,2,3,3};
        int[][] queries = {
                {1,3},
                {2,2},
                {6,1}
        };
        System.out.println(shortestDistanceColor(colors, queries));
    }
}
