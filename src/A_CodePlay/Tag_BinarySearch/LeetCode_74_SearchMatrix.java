package A_CodePlay.Tag_BinarySearch;

/**
 * 74. 搜索二维矩阵 中等
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_74_SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = 0, n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0) {
            int num = matrix[m][n];
            if (num == target) {
                return true;
            } else if (num < target) {
                m++;
            } else {
                n--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(new LeetCode_74_SearchMatrix().searchMatrix(matrix, 13));
    }
}
