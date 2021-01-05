package A_LeetCodeContest;

import java.util.Arrays;
import java.util.Scanner;

public class ByteDance01 {

    private static int[] parent;

    public static int friendCycle(int[][] matrix) {
        int len = matrix.length;
        parent = new int[len];
        Arrays.fill(parent, -1);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (matrix[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int count = 0;
        for (int key : parent) {
            if (key == -1) {
                count++;
            }
        }
        return count;
    }

    static void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x != y) {
            parent[y] = x;
        }
    }

    static int find(int key) {
        if (parent[key] == -1) {
            return key;
        }
        parent[key] = find(parent[key]);
        return parent[key];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        int res = friendCycle(matrix);
        System.out.println(res);
    }
}
