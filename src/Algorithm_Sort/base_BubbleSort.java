package Algorithm_Sort;

import static Algorithm_Sort.SortUtils.*;

/*
    冒泡排序最好的时间复杂度为O(n)。
    冒泡排序的最坏时间复杂度为O(n2)。
    时间复杂度这个指标看的是最坏的情况，而不是最好的情况，所以冒泡排序的时间复杂度是 O(n2)。
    冒泡排序是一种稳定排序算法。
 */
public class base_BubbleSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int last = array.length;
        //Sorting
        boolean swap;
        do {
            swap = false;
            for (int count = 0; count < last - 1; count++) {
                if (less(array[count], array[count + 1])) {
                    swap = swap(array, count, count + 1);
                }
            }
            last--;
        } while (swap);
        return array;
    }

    /*private static void sort(int arr[]){
        //long start = System.currentTimeMillis();
        //两层循环，外层冒泡轮数，里层依次比较,时间复杂度为O(n2)
        for( int i = 0; i < arr.length; i++ ){
            boolean isSort = true;
            for(int j = 0; j < arr.length - 1 - i ; j++){
                int temp = 0;
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort){break;}//优化:一个有序的数组就不再遍历了.
        }

        System.out.println(Arrays.toString(arr));

        //System.out.println(System.currentTimeMillis() - start);
    }*/

    public static void main(String[] args) {
        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        base_BubbleSort bubbleSort = new base_BubbleSort();
        bubbleSort.sort(integers);

        // Output => 231, 78, 54, 23, 12, 9, 6, 4, 1
        print(integers);

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};
        //Output => e, d, c, b, a
        print(bubbleSort.sort(strings));
    }
}
