package A_CodePlay.Tag_Math;

import java.util.HashMap;

/**
 * 171. Excel表列序号 简单
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * 示例 1:
 * 输入: "A"
 * 输出: 1
 *
 * 示例 2:
 * 输入: "AB"
 * 输出: 28
 *
 * 示例 3:
 * 输入: "ZY"
 * 输出: 701
 */
public class LeetCode_171_TitleToNumber {
    public static int titleToNumber(String s) {
        /*HashMap<Character,Integer> map = new HashMap<>();
        int value = 1;
        for (char k = 'A'; k <='Z'; k++){
            map.put(k,value);
            value++;
        }
        int sum = map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            sum = sum * 26 + map.get(s.charAt(i));
        }
        return sum;*/

        /**
         * 思路: 类似26进制
         * 初始化结果ans = 0，遍历时将每个字母与A做减法，因为A表示1，所以减法后需要每个数加1，计算其代表的数值num = 字母 - ‘A’ + 1
         * 因为有26个字母，所以相当于26进制，每26个数则向前进一位
         * 所以每遍历一位则ans = ans * 26 + num
         * 以ZY为例，Z的值为26，Y的值为25，则结果为26 * 26 + 25=701
         * 时间复杂度：O(n)
         */
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ZY";
        System.out.println(titleToNumber(s));
    }
}
