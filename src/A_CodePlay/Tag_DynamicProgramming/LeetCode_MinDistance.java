package A_CodePlay.Tag_DynamicProgramming;

/**
 * 72. 编辑距离 困难
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 *
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 */
public class LeetCode_MinDistance {

    /**
     * 问题1：如果 word1[0..i-1] 到 word2[0..j-1] 的变换需要消耗 k 步，那 word1[0..i] 到 word2[0..j] 的变换需要几步呢？
     *
     * 答：先使用 k 步，把 word1[0..i-1] 变换到 word2[0..j-1]，消耗 k 步。
     * 再把 word1[i] 改成 word2[j]，就行了。
     * 如果 word1[i] == word2[j]，什么也不用做，一共消耗 k 步，否则需要修改，
     * 一共消耗 k + 1 步。
     *
     * 问题2：如果 word1[0..i-1] 到 word2[0..j] 的变换需要消耗 k 步，那 word1[0..i] 到 word2[0..j] 的变换需要消耗几步呢？
     *
     * 答：先经过 k 步，把 word1[0..i-1] 变换到 word2[0..j]，消耗掉 k 步，
     * 再把 word1[i] 删除，这样，word1[0..i] 就完全变成了 word2[0..j] 了。
     * 一共 k + 1 步。
     *
     * 问题3：如果 word1[0..i] 到 word2[0..j-1] 的变换需要消耗 k 步，那 word1[0..i] 到 word2[0..j] 的变换需要消耗几步呢？
     *
     * 答：先经过 k 步，把 word1[0..i] 变换成 word2[0..j-1]，消耗掉 k 步，
     * 接下来，再插入一个字符 word2[j], word1[0..i] 就完全变成了 word2[0..j] 了。
     */
    public int minDistance(String word1, String word2) {
        int M = word1.length(), N = word2.length();
        int[][] ans = new int[M+1][N+1];

        for (int i = 0; i <= M; ++i) {
            ans[i][0] = i;
        }
        for (int j = 0; j <= N; ++j) {
            ans[0][j] = j;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    ans[i][j] = ans[i-1][j-1];
                } else { //replace, insert, delete
                    ans[i][j] = 1 + Math.min(ans[i-1][j-1],Math.min(ans[i][j-1],ans[i-1][j]));
                }
            }
        }
        return ans[M][N];
    }

    public static void main(String[] args) {

    }
}
