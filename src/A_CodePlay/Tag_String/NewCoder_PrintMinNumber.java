package A_CodePlay.Tag_String;

import java.util.Arrays;

/**
 * 剑指 Offer 45. 把数组排成最小的数 中等
 *
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 */
public class NewCoder_PrintMinNumber {
    
    /**
     * 思路:
     * 可以看成是一个排序问题，在比较两个字符串 S1 和 S2 的大小时，应该比较的是 S1+S2 和 S2+S1 的大小，
     * 如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，否则应该把 S2 排在前面。
     */
    public static String printMinNumber(int[] numbers) {
        if (numbers == null) {
            return "";
        }
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = numbers[i] + "";
        }
        Arrays.sort(str,(s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        String res = "";
        for (String s : str){
            res += s;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = {10, 2};
        System.out.println(printMinNumber(numbers));
    }
}
