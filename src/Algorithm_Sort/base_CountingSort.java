package Algorithm_Sort;

import java.util.Arrays;

/**
 * 计数排序是一种非基于比较的排序算法，各种排序算法几乎都是基于元素之间的比较来进行排序的，
 * 计数排序的时间复杂度为 O(n + m )，m 指的是数据量，说的简单点，
 * 计数排序算法的时间复杂度约等于 O(n)，快于任何比较型的排序算法。
 * 计数排序只适用于正整数并且取值范围相差不大的数组排序使用，它的排序的速度是非常可观的。
 */
public class base_CountingSort {

    public static void sort(int[] arr) {
        //找出数组中的最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        //初始化计数数组
        int[] countArr = new int[max + 1];

        //计数
        for (int i = 0; i < arr.length; ++i) {
            countArr[arr[i]]++;
        }

        //顺序累加
        for (int i = 1; i < max + 1; ++i) {
            countArr[i] = countArr[i-1] + countArr[i];
        }

        //排序后的数组
        int[] sortedArr = new int[arr.length];

        //排序
        for (int i = arr.length - 1; i >= 0; --i) {
            sortedArr[countArr[arr[i]]-1] = arr[i];
            countArr[arr[i]]--;
        }

        //将排序后的数据拷贝到原数组
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = sortedArr[i];
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] a = {4, 23, 6, 78, 1, 54, 23, 1, 9, 231, 9, 12};
        sort(a);//[1, 1, 4, 6, 9, 9, 12, 23, 23, 54, 78, 231]
    }
}
