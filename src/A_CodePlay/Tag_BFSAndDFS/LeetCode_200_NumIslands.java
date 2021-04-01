package A_CodePlay.Tag_BFSAndDFS;

/**
 * 200. 岛屿数量 中等
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
 * 并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 */
public class LeetCode_200_NumIslands {
    /**
     * 思路：遍历岛这个二维数组，如果当前数为1，则进入感染函数并将岛个数+1
     * 感染函数：其实就是一个递归标注的过程，它会将所有相连的1都标注成2。
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '#';
        dfs(grid, i-1, j); //Up
        dfs(grid, i+1, j); //Down
        dfs(grid, i, j-1); //Left
        dfs(grid, i, j+1); //Right
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        LeetCode_200_NumIslands n = new LeetCode_200_NumIslands();
        System.out.println(n.numIslands(grid));
    }
}
