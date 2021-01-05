package Algorithm_Sort;

import java.util.Random;


/**
 * 猴子排序 (Bogo Sort) 是个既不实用又原始的排序算法.
 * 其原理等同将一堆卡片抛起，落在桌上后检查卡片是否已整齐排列好，若非就再抛一次。
 * 在最坏的情况下所需时间是无限的.
 * Bogo排序是一种基于生成和测试范例的高效无效的排序功能
 */

/**
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SortAlgorithm
 */
public class base_BogoSort implements SortAlgorithm {

    private static final Random random = new Random();


    private static <T extends Comparable<T>> boolean isSorted(T array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            if (SortUtils.less(array[i + 1], array[i])) return false;
        }
        return true;
    }

    // Randomly shuffles the array
    private static <T> void nextPermutation(T array[]) {
        int length = array.length;

        for (int i = 0; i < array.length; i++) {
            int randomIndex = i + random.nextInt(length - i);
            SortUtils.swap(array, randomIndex, i);
        }
    }

    public <T extends Comparable<T>> T[] sort(T array[]) {
        while (!isSorted(array)) {
            nextPermutation(array);
        }
        return array;
    }

    // Driver Program
    public static void main(String[] args) {
        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        base_BogoSort bogoSort = new base_BogoSort();

        // print a sorted array
        SortUtils.print(bogoSort.sort(integers));

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};

        SortUtils.print(bogoSort.sort(strings));
    }
}
