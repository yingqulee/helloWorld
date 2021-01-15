package A_CodePlay.Tag_TwoPointer;

import java.util.HashSet;
import java.util.Set;

/**
 * 345. 反转字符串中的元音字母 简单
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 */
public class LeetCode_ReverseVowels {

    public String reverseVowels(String s) {
        if(s.length() <= 1){
            return s;
        }
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (vowels.indexOf(chars[left]) == -1 && left < right) {
                ++left;
            }
            while (vowels.indexOf(chars[right]) == -1 && left < right) {
                --right;
            }
            if (left < right) {
                char c = chars[left];
                chars[left++] = chars[right];
                chars[right--] = c;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        LeetCode_ReverseVowels l = new LeetCode_ReverseVowels();
        System.out.println(l.reverseVowels("hello"));
    }
}
