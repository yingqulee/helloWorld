package Algorithm_Sort;

import static Algorithm_Sort.SortUtils.*;

/**
 * Implementation of gnome sort
 *
 * 侏儒排序类似于插入排序的排序算法，除了将元素移动到适当的位置是通过一系列交换完成的，如冒泡排序。
 * 它在概念上很简单，不需要嵌套循环平均或预期的运行时间是O（n2），但如果列表最初几乎排序，则倾向于O（n）
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @since 2018-04-10
 **/
public class base_GnomeSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int i = 1;//当前位置
        int j = 2;
        while (i < arr.length) {
            if (less(arr[i - 1], arr[i])) i = j++;
            else {
                swap(arr, i - 1, i);
                if (--i == 0) {
                    i = j++;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Integer[] integers = {5,3,2,4};

//        String[] strings = {"c", "a", "e", "b", "d", "dd", "da", "zz", "AA", "aa", "aB", "Hb", "Z"};
        base_GnomeSort gnomeSort = new base_GnomeSort();

        gnomeSort.sort(integers);
//        gnomeSort.sort(strings);

        System.out.println("After sort : ");
        print(integers);
//        print(strings);


    }

}
