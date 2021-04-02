package Algorithm_Sort;

import static Algorithm_Sort.SortUtils.less;
import static Algorithm_Sort.SortUtils.print;

/*
    插入排序的思想和我们打扑克摸牌的时候一样，从牌堆里一张一张摸起来的牌都是乱序的，
    我们会把摸起来的牌插入到左手中合适的位置，让左手中的牌时刻保持一个有序的状态。

    插入排序对于大规模的乱序数组的时候效率是比较慢的，因为它每次只能将数据移动一位.

    插入排序最好情况的时间复杂度是 O(n)，
    插入排序最坏情况的时间复杂度是 O(n2)，
    时间复杂度这个指标看的是最坏的情况，而不是最好的情况，所以插入排序的时间复杂度是 O(n2)。
 */
public class base_InsertionSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int j = 1; j < array.length; j++) {

            // Picking up the key(Card)
            T key = array[j];
            int i = j - 1;

            while (i >= 0 && less(key, array[i])) {
                array[i + 1] = array[i];
                i--;
            }
            // Placing the key (Card) at its correct position in the sorted subarray
            array[i + 1] = key;
        }
        return array;
    }

    /*private static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int value = arr[i];
            int j = 0;//插入的位置

            for (j = i - 1; j >= 0; j--) {
                if (arr[j] < value) {
                    arr[j+1] = arr[j];//移动数据
                } else {
                    break;
                }
            }

            arr[j + 1] = value;
        }

        System.out.println(Arrays.toString(arr));
    }*/

    public static void main(String[] args) {

        base_InsertionSort sort = new base_InsertionSort();

        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        sort.sort(integers);

        // Output => 1 4 6 9 12 23 54 78 231
        print(integers);

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};

        sort.sort(strings);

        //Output => a	b	c	d	e
        print(strings);
    }
}
