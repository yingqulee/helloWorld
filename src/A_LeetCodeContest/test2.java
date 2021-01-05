package A_LeetCodeContest;

import java.util.Arrays;

public class test2 {

    private static void rotate(char[] c) {
        int i = 0, j = 0;
        int len = c.length;
        while (j < len) {
            if (c[j] != '.') {
                j++;
            } else {
                reverse(c , i, j-1);
                i = j +1;
                j++;
            }
        }
        reverse(c, i, j-1);
        reverse(c,0, len-1);
    }

    private static void reverse(char[] c, int i, int j) {
        while (i < j) {
            char tmp = c[i];
            c[i++] = c[j];
            c[j--] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'w','w','w','.','b','a','i','d','u','.','c','o','m'};
        rotate(chars);
        System.out.println(Arrays.toString(chars));
    }
}
