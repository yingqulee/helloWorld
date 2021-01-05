package A_CodePlay.Tag_Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面 简单
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class NewCoder_ReOrderArray {

    public static void reOrderArray(int [] nums) {
        ArrayList<Integer> tempX = new ArrayList<>();
        ArrayList<Integer> tempY = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2!= 0)
                tempX.add(nums[i]);
            else
                tempY.add(nums[i]);
        }
        for (int i = 0; i < tempX.size(); i++) {
            nums[i] = tempX.get(i);
        }
        for (int i = 0; i < tempY.size(); i++) {
            nums[tempX.size() + i] = tempY.get(i);
        }
        System.out.println(Arrays.toString(nums));
    }

    //简化
    public static void reOrderArray02(int [] nums) {
        int oddCount = 0;
        for (int num : nums) {
            if (num % 2 != 0)
                oddCount++;
        }
        int[] copy = nums.clone();
        int i = 0, j = oddCount;
        for (int num : copy) {
            if (num % 2 != 0)
                nums[i++] = num;
            else
                nums[j++] = num;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        reOrderArray02(nums);
    }
}
