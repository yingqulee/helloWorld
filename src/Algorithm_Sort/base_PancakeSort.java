package Algorithm_Sort;

import static Algorithm_Sort.SortUtils.*;

/**
 * Implementation of PancakeSort
 *
 * 煎饼排序
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @since 2018-04-10
 **/
public class base_PancakeSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int size = array.length;

        for (int i = 0; i < size; i++) {
            T max = array[0];
            int index = 0;
            for (int j = 0; j < size - i; j++) {
                if (less(max, array[j])) {
                    max = array[j];
                    index = j;
                }
            }
            flip(array, index, array.length - 1 - i);
        }
        return array;
    }


    public static void main(String[] args) {

        Integer[] arr = {5,3,2,4};
        base_PancakeSort pancakeSort = new base_PancakeSort();
        System.out.println("After sorting:");
        pancakeSort.sort(arr);
        print(arr);
    }


}
