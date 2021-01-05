package A_Others;

import java.util.Random;

/*
    在实现Fisher-Yates费雪耶兹随机置乱算法时，可能会出现偏差，尽管这种偏差是非常不明显的。
    原因：一是实现算法本身出现问题；二是算法基于的随机数生成器
 */
public class FisherYatesShuffle {

    public static void main(String[] args) {
        int[] arr = new int[10];
        int i;
        //初始的有序数组
        System.out.println("初始有序数组:");
        for (i = 0; i < 10; i++) {
            arr[i] = i + 1;
            System.out.print(" " + arr[i]);
        }
        //费雪耶兹置乱算法
        System.out.println("\n" + "每次生成的随机交换位置:");
        for (i = arr.length - 1; i > 0; i--) {
            //随机数生成器，范围[0, i]
            int rand = (new Random()).nextInt(i+1);
            System.out.print(" " + rand);

            int temp = arr[i];
            arr[i] = arr[rand];
            arr[rand] = temp;
        }
        //置换之后的数组
        System.out.println("\n" + "置换后的数组:");
        for (int k: arr)
            System.out.print(" " + k);

    }
}
