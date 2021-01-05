package A_CodePlay.Tag_TwoPointer;

/**
 * 28. 实现 strStr() 简单
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class LeetCode_StrStr {

    //暴力子字符串查找算法1
    public static int strStr01(String haystack, String needle) {

        if (haystack == null && needle == null) return 0;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;//找到后返回
            }
        }
        return -1;//未找到
    }

    //暴力子字符串查找算法2 -- 显示回退
    public static int strStr02(String haystack, String needle) {
        int i,j;
        for (i = 0, j = 0; i < haystack.length() && j < needle.length(); i++){
            if (haystack.charAt(i) == needle.charAt(j))j++;
            else {
                i -= j;
                j = 0;
            }
        }
        if (j == needle.length()) return i - needle.length();
        else return -1;
    }

    //KMP

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr01(haystack,needle));
    }
}
