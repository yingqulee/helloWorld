package A_CodePlay.Tag_String;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符 简单
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 */
public class LeetCode_387_FirstUniqChar {

    public static int firstUniqChar01(String s) {
        Map<Character,Integer> ans = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (ans.containsKey(s.charAt(i))){
                ans.put(s.charAt(i),1);
            }else ans.put(s.charAt(i),0);
        }
        for (int i = 0; i < s.length(); i++) {
            if (ans.get(s.charAt(i)) == 0)
                return i;
        }
        return -1;
    }

    public static int firstUniqChar02(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar02(s));
    }
}
