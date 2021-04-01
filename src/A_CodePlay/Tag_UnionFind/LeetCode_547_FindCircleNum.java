package A_CodePlay.Tag_UnionFind;

import java.util.Arrays;

/**
 * 547. 省份数量  中等
 *
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 *
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 *
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-provinces
 */
public class LeetCode_547_FindCircleNum {

    //并查集实现
    private int[] parent;

    private void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x != y) {
            parent[y] = x;
        }
    }

    private int find(int x) {
        if (parent[x] == -1) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        parent = new int[len];
        Arrays.fill(parent, -1);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int count = 0;
        for (int key : parent) {
            if (key == -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        LeetCode_547_FindCircleNum l = new LeetCode_547_FindCircleNum();
        System.out.println(l.findCircleNum(isConnected));
    }
}
