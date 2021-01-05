package A_LeetCodeContest;

import java.util.Scanner;

/**
 * 卡特兰数
 */
public class ByteDance02 {

    public static int enter(int n) {
        int[] C = new int[n+1];
        C[0] = 1;
        C[2] = 1;
        C[4] = 2;
        for (int i = 6; i < n + 1; i++) {
            for (int j = 0; j < i - 2 + 1; j++) {
                if (j % 2 == 0) {
                    C[i] += C[j] * C[i-2-j];
                }
            }
        }
        return C[n];
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        System.out.println(enter(N));
    }
}
