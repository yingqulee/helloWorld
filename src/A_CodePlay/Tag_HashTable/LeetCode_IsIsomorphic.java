package A_CodePlay.Tag_HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串 简单
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 */
public class LeetCode_IsIsomorphic {

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char S = s.charAt(i);
            char T = t.charAt(i);
            if (map.containsKey(S)) {
                if (map.get(S) != T) {
                    return false;
                }
            } else {
                if (map.containsValue(T)) {
                    return false;
                }
                map.put(S,t.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";
        System.out.println(isIsomorphic(s,t));
    }
}
