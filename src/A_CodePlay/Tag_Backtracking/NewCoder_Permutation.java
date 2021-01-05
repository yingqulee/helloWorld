package A_CodePlay.Tag_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 剑指 Offer 38. 字符串的排列 中等
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class NewCoder_Permutation {

    private static ArrayList<String> res = new ArrayList<>();

    public static ArrayList<String> permutation(String str) {
        if (str == null || str.length() == 0){
            return res;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtrack(chars,new boolean[chars.length], new StringBuilder());
        return res;
    }
    private static void backtrack(char[] chars, boolean[] visited, StringBuilder helper) {
        if (helper.length() == chars.length){
            res.add(helper.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            helper.append(chars[i]);
            backtrack(chars, visited, helper);
            helper.deleteCharAt(helper.length() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permutation("abc"));
    }
}
