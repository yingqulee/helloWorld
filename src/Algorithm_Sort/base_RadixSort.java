package Algorithm_Sort;

import java.util.Arrays;

/**
 * 基数排序是一种非比较型整数排序算法，其原理是将数据按位数切割成不同的数字，然后按每个位数分别比较。
 * 基数排序可以看成桶排序的扩展，也是用桶来辅助排序
 * 0 - 9 最多也就十个桶：先按权重小的位置排序，然后按权重大的位置排序。
 */
public class base_RadixSort {

    private static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++) {
            mx = Math.max(mx, arr[i]);
        }
        return mx;
    }

    private static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);//初始化数组

        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    private static void radixSort(int arr[], int n) {

        int m = getMax(arr, n);

        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }



    public static void main(String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}
