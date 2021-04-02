package Algorithm_Sort;

import java.util.Arrays;
import java.util.LinkedList;

/*
    快速排序（QuickSort）是对冒泡排序的一种改进,
    快速排序不是一种稳定的排序算法，也就是说，多个相同的值的相对位置也许会在算法结束时产生变动。
    快速排序的时间复杂度是 O(nlogn)，极端情况下会退化成 O(n2)
    快速排序的空间复杂度为 O(1)。

    快速排序的核心思想也是分治法，分而治之。它的实现方式是每次从序列中选出一个基准值，
    其他数依次和基准值做比较，比基准值大的放右边，比基准值小的放左边，
    然后再对左边和右边的两组数分别选出一个基准值，进行同样的比较移动，
    重复步骤，直到最后都变成单个元素，整个数组就成了有序的序列。

    快速排序的关键之处在于切分，切分的同时要进行比较和移动，这里介绍一种叫做单边扫描的做法。
    单边扫描:
        随意抽取一个数作为基准值，同时设定一个标记 mark 代表左边序列最右侧的下标位置，当然初始为 0 ，
        接下来遍历数组，如果元素大于基准值，无操作，继续遍历，如果元素小于基准值，则把 mark + 1 ，
        再将 mark 所在位置的元素和遍历到的元素交换位置，mark 这个位置存储的是比基准值小的数据，
        当遍历结束后，将基准值与 mark 所在元素交换位置即可

    双边扫描:
        随意抽取一个数作为基准值，然后从数组左右两边进行扫描，先从左往右找到一个大于基准值的元素，
        将下标指针记录下来，然后转到从右往左扫描，找到一个小于基准值的元素，交换这两个元素的位置，
        重复步骤，直到左右两个指针相遇，再将基准值与左侧最右边的元素交换。
 */
public class base_QuickSort {

    public int[] sort(int[] arr) {
        sort_noRecur(arr,0, arr.length - 1);
        return arr;
    }

    private void sort_recur(int[] arr, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }
        //切分
        int pivotIndex = partitionV1(arr, startIndex, endIndex);
        sort_recur(arr, startIndex, pivotIndex-1);
        sort_recur(arr, pivotIndex+1, endIndex);
    }

    //单边扫描
    private int partitionV1(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];//取基准值
        int mark = startIndex;//Mark初始化为起始下标

        for (int i=startIndex+1; i<=endIndex; i++) {
            if (arr[i] < pivot) {
                //小于基准值 则mark+1，并交换位置。
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        //基准值与mark对应元素调换位置
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    //双边扫描
    private int partitionV2(int[] arr,int startIndex,int endIndex) {
        int left = startIndex;
        int right = endIndex;
        int pivot = arr[startIndex];//取第一个元素为基准值
        while (true) {
            //从左往右扫描
            while (arr[left] <= pivot) {
                left++;
                if (left == right) {
                    break;
                }
            }
            //从右往左扫描
            while (pivot < arr[right]) {
                right--;
                if (left == right) {
                    break;
                }
            }
            //左右指针相遇
            if (left >= right) {
                break;
            }
            //交换左右数据
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        //将基准值插入序列
        int temp = arr[startIndex];
        arr[startIndex] = arr[right];
        arr[right] = temp;
        return right;
    }

    //快排 非递归
    private void sort_noRecur(int[] arr, int startIndex, int endIndex) {
        if (arr == null || startIndex < 0 || endIndex <= 0 || startIndex > endIndex) {
            return;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int i, j;
        // (注意保存顺序) 先将初始状态的左右指针压栈
        stack.push(endIndex);
        stack.push(startIndex);
        while (!stack.isEmpty()) {
            i = stack.pop(); //先弹出左指针
            j = stack.pop(); //再弹出右指针
            if (i < j) {
                int k = partitionV1(arr, i, j);
                if (k > i) {
                    stack.push(k - 1); //保存中间变量
                    stack.push(i); // 保存中间变量
                }
                if (j > k) {
                    stack.push(j);
                    stack.push(k + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {8,9,7,1,6,5,3,4,2,12,56,123};
        base_QuickSort quickSort = new base_QuickSort();
        System.out.println(Arrays.toString(quickSort.sort(a)));
    }
}
