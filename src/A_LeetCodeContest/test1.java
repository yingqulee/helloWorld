package A_LeetCodeContest;
import java.util.Scanner;

public class test1 {

    private static int search(int[] arr,int key,int left, int right) {
        if (right < left) return -1; // this means that the key not found
        int mid = (left + right) / 2;

        if (arr[mid] < key) {
            return search(arr, key, mid+1, right);
        }
        if (arr[mid] > key) {
            return search(arr, key, left, mid-1);
        }
        return mid+1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        int key = in.nextInt();
        int res = search(arr, key, 0, arr.length-1);
        System.out.println(res);
    }
}
