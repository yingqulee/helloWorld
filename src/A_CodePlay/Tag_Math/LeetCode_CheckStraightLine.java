package A_CodePlay.Tag_Math;

/**
 * 1232. 缀点成线 简单
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 *
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 *
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 *
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
 */
public class LeetCode_CheckStraightLine {

    public boolean checkStraightLineI(int[][] coordinates) {
        if (coordinates.length == 2) {
            return true;
        }
        //计算两点之间的斜率;
        for (int i = 1; i < coordinates.length - 1; i++) {
            if (cal(coordinates, i - 1, i) != cal(coordinates, i, i + 1)) {
                return false;
            }
        }
        return true;
    }

    public double cal(int[][] a, int i, int j) {
        if ((a[j][0] - a[i][0]) == 0) {
            return Double.MAX_VALUE;
        }
        return (double)(a[j][1] - a[i][1]) / (double)(a[j][0] - a[i][0]);
    }

    //尽量不要用判断斜率是否相等，可以利用共线向量线性相关
    public boolean checkStraightLineII(int[][] coordinates) {
        int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
        int n = coordinates.length;
        for (int i = 0; i < n; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }
        int A = coordinates[1][1], B = -coordinates[1][0];
        for (int i = 2; i < n; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if (A * x + B * y != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        LeetCode_CheckStraightLine l = new LeetCode_CheckStraightLine();
        System.out.println(l.checkStraightLineII(coordinates));
    }
}
