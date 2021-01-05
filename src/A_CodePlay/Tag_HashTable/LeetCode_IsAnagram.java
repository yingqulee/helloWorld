package A_CodePlay.Tag_HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词 简单
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class LeetCode_IsAnagram {

    public static boolean isAnagram(String s, String t) { //排序写法
        if (s.length() != t.length())return false;
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1,c2);
    }

    public static boolean isAnagram01(String s, String t) { //哈希表写法
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        for (char c : t.toCharArray()) {
            Integer count = map.get(c); //Integer 可以为null
            if (count == null) { //不是异位词
                return false;
            } else if (count > 1) {
                map.put(c, count - 1);
            } else {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram01(s,t));
    }
}
