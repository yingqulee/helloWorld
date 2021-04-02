package Algorithm_Sort;

import java.util.Arrays;

/**利用堆这种数据结构来进行排序的算法
 * 堆是一种优先队列，两种实现，最大堆和最小堆
 * 堆顶元素永远都是整棵树中的最大值
 * 堆排序和快速排序的时间复杂度都一样是 O(nlogn)。
 */
public class base_HeapSort {

    public static void sort(int[] arr) {
        int length = arr.length;
        //构建堆
        buildHeap(arr, length);
        for ( int i = length - 1; i > 0; i-- ) {
            //将堆顶元素与末位元素调换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //数组长度-1 隐藏堆尾元素,就是i
            //将堆顶元素下沉 目的是将最大的元素浮到堆顶来
            sink(arr,0,i);
        }
    }
    private static void buildHeap(int[] arr, int length) {
        for (int i = length / 2; i >= 0; i--) {
            sink(arr, i, length);
        }
    }
    /**
     * 下沉调整
     * @param arr 数组
     * @param index 调整位置
     * @param length 数组范围
     */
    private static void sink(int[] arr, int index, int length) {
        int leftChild = 2 * index + 1;//左子节点下标
        int rightChild = 2 * index + 2;//右子节点下标
        int present = index;//要调整的节点下标

        //下沉左边
        if (leftChild < length && arr[leftChild] > arr[present]) {
            present = leftChild;
        }

        //下沉右边
        if (rightChild < length && arr[rightChild] > arr[present]) {
            present = rightChild;
        }

        //如果下标不相等 证明调换过了
        if (present != index) {
            //交换值
            int temp = arr[index];
            arr[index] = arr[present];
            arr[present] = temp;

            //继续下沉
            sink(arr, present, length);
        }
    }

    public static void main(String[] args) {
        int[] heap = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        sort(heap);
        System.out.println(Arrays.toString(heap)); // [1, 4, 6, 9, 12, 23, 54, 78, 231]
    }
}
