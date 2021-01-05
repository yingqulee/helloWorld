package A_LeetCodeContest;

/**
 * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，
 * 其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
 *
 * 示例 1：
 *
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 * 示例 2：
 *
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 */
public class Contest_NumSmallerByFrequency {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = queries.length;
        int m = words.length;
        int[] wNum = new int[m];
        for(int i = 0; i < m; i++) {
            wNum[i] = f(words[i]);
        }

        int[] res = new int[n];
        for (int i = 0;i < n;i++) {
            int qNum = f(queries[i]);
            for (int j = 0; j < m; j++) {
                if (qNum < wNum[j]) {
                    res[i]++;
                }
            }
        }
        return res;
    }

    public int f(String s) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) {
            f[c-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (f[i] > 0) {
                return f[i];
            }
        }
        return 0;
    }
}
