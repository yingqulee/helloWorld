package A_CodePlay.Tag_Math;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数 简单
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * 示例 1:
 *
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 *
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 *
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 *
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 *
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class LeetCode_RomanToInt {

    /*public static int romanToInt(String s) {

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int result = 0;

        for (int i = 0; i < s.length();) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i,i+2))){
                result += map.get(s.substring(i,i+2));
                i += 2;
            }else {
                result += map.get(s.substring(i,i+1));
                i++;
            }
        }

        return result;
    }*/

    private static Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    /**
     * This function convert Roman number into Integer
     *
     * @param A Roman number string
     * @return integer
     */
    public static int romanToInt(String A) {

        char prev = ' ';

        int sum = 0;

        int newPrev = 0;
        for (int i = A.length() - 1; i >= 0 ; i--) {
            char c = A.charAt(i);

            if (prev != ' ') {
                // checking current Number greater then previous or not
                newPrev = map.get(prev) /*> newPrev ? map.get(prev) : newPrev*/;
            }

            int currentNum = map.get(c);

            // if current number greater then prev max previous then add
            if (currentNum >= newPrev) {
                sum += currentNum;
            } else {
                // subtract upcoming number until upcoming number not greater then prev max
                sum -= currentNum;
            }

            prev = c;
        }

        return sum;
    }

    public static void main(String[] args) {
        String roman = "VI";
        System.out.println(romanToInt(roman));
    }
}
