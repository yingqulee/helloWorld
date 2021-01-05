package A_Others;

/**
 * 练习: count the paths
 */
public class DynamicProgram {

    private static int countThePaths(char[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int i = 0; i < n; i++)
            dp[0][i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '#') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {' ',' ',' ',' ',' ',' ',' ',' '},
                {' ',' ','#',' ',' ',' ','#',' '},
                {' ','#',' ','#','#',' ',' ',' '},
                {' ',' ',' ',' ',' ','#',' ',' '},
                {' ',' ','#',' ',' ','#',' ','#'},
                {' ',' ',' ','#',' ',' ',' ',' '},
                {' ','#',' ',' ',' ','#',' ',' '},
                {' ',' ',' ',' ',' ',' ',' ',' '}
        };
        System.out.println(countThePaths(matrix));
    }
}
