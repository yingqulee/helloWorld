package A_CodePlay.Tag_Array;


import java.util.Arrays;

/**
 *  66. 加一 简单
 *  给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 *  最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 *  你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *  输入: [1,2,3]
 *  输出: [1,2,4]
 *  解释: 输入数组表示数字 123。
 *
 *  //为了更好理解题意，根据 LeetCode 评论区评论新增一个示例
 *  输入: [9,9]
 *  输出: [1，0，0]
 *  解释: 输入数组表示数字 100。
 */
public class LeetCode_PlusOne {

    public static int[] plusOne(int[] arr){
        //从数组末尾开始向前遍历
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] < 9) {
                arr[i]++;
                //整体没有进位,直接返回
                return arr;
            }
            //产生进位
            arr[i] = 0;
        }
        //整体产生了进位，数组长度需要变化加 1
        int[] res = new int[arr.length + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        int[] a ={1,3,9};
        int[] array = plusOne(a);

        System.out.println(Arrays.toString(array));
    }
}
