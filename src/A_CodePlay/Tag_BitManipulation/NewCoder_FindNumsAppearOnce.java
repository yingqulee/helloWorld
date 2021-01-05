package A_CodePlay.Tag_BitManipulation;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数 中等
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class NewCoder_FindNumsAppearOnce {

    public static int[] findNumsAppearOnce(int [] array) {
        //num1,num2分别为长度为1的数组。传出参数
        //将num1[0],num2[0]设置为返回结果
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : array) {
            if (map.containsKey(num))
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1 && res[0] == 0)
                res[0] = key;
            else if (map.get(key) == 1 && res[1] == 0)
                res[1] = key;
        }
        return res;
    }

    /**
     * 思路
     * 两个不相等的元素在位级表示上必定会有一位存在不同，将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
     * diff &= -diff 得到出 diff 最右侧不为 0 的位，
     * 也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。
     */
    public static int[] findNumsAppearOnce01(int [] nums) {
        int diff = 0;
        int[] res = new int[2];
        for (int num : nums)
            diff ^= num;
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0)
                res[0] ^= num;
            else
                res[1] ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10,10,9,8,7,6,5,2,3};
        System.out.println(Arrays.toString(findNumsAppearOnce(array)));
    }
}
