package A_LeetCodeContest;

import java.util.HashMap;
import java.util.Map;

/**5048. 拼写单词
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 * 示例 1：
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 *
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 */
public class Contest_CountCharacters {

    public int countCharacters(String[] words, String chars) {
        int res = 0;
        int[] c = count(chars);

        for (String word: words) {
            int[] tmp = count(word);
            boolean remb = true;
            for (int i = 0; i < 26; i++) {
                if (tmp[i] > c[i]) {
                    remb = false;
                    break;
                }
            }
            res += remb == true ?  word.length() : 0;
        }
        return res;
    }

    private int[] count(String str) {
        int[] temp = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            temp[ch - 'a'] ++;
        }
        return temp;
    }

    public static void main(String[] args) {

    }
}
