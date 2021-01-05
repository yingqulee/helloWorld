package Algorithm_Sort;

import java.util.Arrays;

/*
    希尔排序(Shell's Sort)是插入排序的一种又称“缩小增量排序”（Diminishing Increment Sort），
    是直接插入排序算法的一种更高效的改进版本。
    希尔排序是非稳定排序算法。O(nlogn)

    希尔排序为了加快插入的速度，让数据移动的时候可以实现跳跃移动，节省了一部分的时间开支。
 */
public class base_ShellSort {

    private static void sort(int[] arr){
        int length = arr.length;
        //区间
        int gap = 1;
        //为什么区间要以 gap = gap*3 + 1 去计算，其实最优的区间计算方法是没有答案的，
        //这是一个长期未解决的问题，不过差不多都会取在二分之一到三分之一附近。
        while (gap < length) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                //跨区间排序
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = gap / 3;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int a[] = {8,9,7,1,6,5,3,4,2};
        sort(a);
    }
}
