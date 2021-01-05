package Algorithm_Sort;


import java.util.Arrays;

/*  选择排序:
    从数组中选择最小元素，将它与数组的第一个元素交换位置。再从数组剩下的元素中选择出最小的元素，
    将它与数组的第二个元素交换位置。不断进行这样的操作，直到将整个数组排序。

    选择排序需要 ~N2/2 次比较和 ~N 次交换，它的运行时间与输入无关，
    这个特点使得它对一个已经排序的数组也需要这么多的比较和交换操作。


    选择排序是一个不稳定的排序算法
    时间复杂度和冒泡一模一样，都是O(n2)。
 */
public class base_SelectionSort {

    private static void sort(int arr[]){
        //双层循环，时间复杂度和冒泡一模一样，都是O(n2)。
        for (int i = 0; i < arr.length; i++) {
            int min = i;//最小元素的下标
            for (int j = i+1 ; j < arr.length; j++) {
                if (arr[j] < arr[min]){
                    min = j;//找最小值
                }
            }
            if (min!=i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int a[] = {8,7,1,9,5};
        sort(a);
    }
}

