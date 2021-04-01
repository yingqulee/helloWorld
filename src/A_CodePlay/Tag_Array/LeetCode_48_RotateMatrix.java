package A_CodePlay.Tag_Array;

/**
 * 48. 旋转图像 中等
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像
 *
 * 示例 1:
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 示例 2:
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class LeetCode_48_RotateMatrix {

    public static void rotate(int[][] matrix) {
        //这个为啥不行
        /*int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //矩阵调换列元素
        int a=0;
        int b=matrix.length-1;
        for(int i=0;i < (matrix.length)/2;i++){
            for(int j=0;j<matrix.length;j++){
                int k=matrix[j][a];
                matrix[j][a]=matrix[j][b];
                matrix[j][b]=k;
            }
        }*/

        //在单次循环中旋转 4 个矩形
        int l = matrix.length - 1;
        for (int i = 0; i < (l+1)/ 2; i++) {
            for (int j = i; j < l - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[l-j][i];
                matrix[l-j][i] = matrix[l-i][l-j];
                matrix[l-i][l-j] = matrix[j][l-i];
                matrix[j][l-i] = tmp;

            }
        }

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    //方法三：用翻转代替旋转
    public static void rotateI(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public static void main(String[] args) {

        /*Scanner in = new Scanner(System.in);
        System.out.print("请输入n的值 :");
        int n = in.nextInt();

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }*/
        int[][] a = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7},{15,14,12,16}};
        rotate(a);
    }
}
