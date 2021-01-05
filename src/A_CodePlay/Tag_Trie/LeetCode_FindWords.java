package A_CodePlay.Tag_Trie;

import java.util.*;

/**
 * 212. 单词搜索 II
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode_FindWords {

    Set<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        /* build a word trie */
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        /* build a boolean[][] check the word was visited */
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie){//使用前缀树
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        if (visited[x][y]) return;

        str += board[x][y];
        /* Not a word */
        if (!trie.startsWith(str)) return;

        /* Is a word add into result*/
        if (trie.search(str)) {
            res.add(str);
        }
        visited[x][y] = true;
        /* Up Search */
        dfs(board, visited, str, x - 1, y, trie);
        /* Down Search */
        dfs(board, visited, str, x + 1, y, trie);
        /* Left Search */
        dfs(board, visited, str, x, y - 1, trie);
        /* Right Search */
        dfs(board, visited, str, x, y + 1, trie);
        visited[x][y] = false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        LeetCode_FindWords f = new LeetCode_FindWords();
        System.out.println(f.findWords(board, words));
    }
}
