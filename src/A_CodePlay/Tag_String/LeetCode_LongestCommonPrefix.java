package A_CodePlay.Tag_String;

/**
 * 14. 最长公共前缀 简单
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:所有输入只包含小写字母 a-z 。
 */
public class LeetCode_LongestCommonPrefix {

    //水平扫描法一
    public static String longestCommonPrefix01(String[] strs) {

        if (strs.length == 0 || strs == null) return "";

        String prefix = strs[0];
        /**
         * 最坏的情况下，n 个字符串都是相同的。算法会将 S1 与其他字符串都做一次比较。
         * 这样就符会进行 S 次字比较，其中 S 是输入数据中所有字符数量
         */
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {

                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) return "";

            }
        }
        return prefix;
    }

    //水平扫描法二
    public static String longestCommonPrefix02(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length() ; i++){

            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        /*String str1 = "0123456789";
        String s = str1.substring(0, 2);
        System.out.println(s);//01*/
        String[] str = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix02(str));
    }
}
