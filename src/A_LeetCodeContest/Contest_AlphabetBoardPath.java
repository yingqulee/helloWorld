package A_LeetCodeContest;


/**
 * 我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
 *
 * 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"].
 *
 * 我们可以按下面的指令规则行动：
 *
 * 如果方格存在，'U' 意味着将我们的位置上移一行；
 * 如果方格存在，'D' 意味着将我们的位置下移一行；
 * 如果方格存在，'L' 意味着将我们的位置左移一列；
 * 如果方格存在，'R' 意味着将我们的位置右移一列；
 * '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
 * 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
 *
 * 示例 1：
 *
 * 输入：target = "leet"
 * 输出："DDR!UURRR!!DDD!"
 * 示例 2：
 *
 * 输入：target = "code"
 * 输出："RR!DDRR!UUL!R!"
 */
public class Contest_AlphabetBoardPath {

    public static String alphabetBoardPath(String target) {
        String res = "";
        int row = 0, col = 0;
        for (int i = 0; i < target.length(); i++) {

            int idx = target.charAt(i) - 'a';

            //根据字母的位置,求出行的坐标 row_i, 列的坐标 col_j;
            int row_i = idx / 5, col_j = idx % 5;

            while (row > row_i) {
                res += "U";
                --row;
            }
            while (col > col_j) {
                res += "L";
                --col;
            }
            while (col < col_j) {
                res += "R";
                ++col;
            }
            while (row < row_i) {
                res += "D"; ++row;
            }
            res += "!";
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(alphabetBoardPath("leet"));
    }
}
