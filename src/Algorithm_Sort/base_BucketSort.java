package Algorithm_Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 桶排序可以看成是计数排序的升级版，它将要排的数据分到多个有序的桶里，
 * 每个桶里的数据再单独排序，再把每个桶的数据依次取出，即可完成排序。
 * 桶排序最好情况下使用线性时间O(n)，桶排序的时间复杂度，取决与对各个桶之间数据进行排序的时间复杂度，
 * 因为其它部分的时间复杂度都为O(n)。很显然，桶划分的越小，各个桶之间的数据越少，排序所用的时间也会越少。
 * 但相应的空间消耗就会增大。
 */
public class base_BucketSort {
    public static void sort(int[] arr) {
        //最大最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        //最大值和最小值的差
        int diff = max - min;

        //桶列表
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            bucketList.add(new ArrayList<>());
        }

        //每个桶的存数区间
        float section = (float) diff / (float) (arr.length - 1);

        //数据入桶
        for (int i = 0; i < arr.length; i++) {
            //当前数除以区间得出存放桶的位置 减1后得出桶的下标
            int num = (int) (arr[i] / section) - 1;
            if(num < 0){
                num = 0;
            }
            bucketList.get(num).add(arr[i]);
        }

        //桶内排序
        for (int i = 0; i < bucketList.size(); i++) {
            //jdk的排序速度当然信得过
            Collections.sort(bucketList.get(i));
        }

        //写入原数组
        int index = 0;
        for (ArrayList<Integer> arrayList : bucketList) {
            for (int value : arrayList) {
                arr[index] = value;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] bucket = {4, 23, 6, 78, 1, 54, 23, 1, 9, 231, 9, 12};
        sort(bucket);
        System.out.println(Arrays.toString(bucket)); // [1, 1, 4, 6, 9, 9, 12, 23, 23, 54, 78, 231]
    }
}
