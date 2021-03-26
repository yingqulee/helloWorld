package A_CodePlay.Tag_Array;

import java.util.HashSet;
import java.util.Set;

/**
 * 1502. 判断能否形成等差数列 简单
 *
 * 给你一个数字数组 arr 。
 *
 * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 *
 * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,5,1]
 * 输出：true
 * 解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
 * 示例 2：
 *
 * 输入：arr = [1,2,4]
 * 输出：false
 * 解释：无法通过重新排序得到等差数列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence
 */
public class LeetCode_CanMakeArithmeticProgression {

    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length <= 2) {
            return true;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        if ((max - min) % (arr.length - 1) != 0) {
            return false;
        }
        int diff = (max - min) / (arr.length - 1);
        // Case 0: {1,1,1,1} or {0,0,0,0}
        if (diff == 0 && min == max) {
            return true;
        }
        int index = 0;
        // swap each num to according place
        // min + 0 * gap, min + 1 * gap, min + 2 * gap, ..., min + (arr.length - 1) * gap
        while (index < arr.length) {
            // Case 1: {1,2,5,7} meet with arr[i] which can not be put anywhere
            if ((arr[index] - min) % diff != 0) {
                return false;
            }
            int j = (arr[index] - min) / diff;
            // Case 2: {1,2,3,4} -> {1,2,3,4} i++ when arr[i] is at the right place
            if (j == index) {
                index++;
            } else {
                // Case 3: {1,2,2,4} meet with duplicate
                if(arr[index] == arr[j]) {
                    return false;
                }
                // Case 4: {2,1,3,4} -> {1,2,3,4} after swap 2 and 1
                int tmp = arr[j];
                arr[j] = arr[index];
                arr[index] = tmp;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_CanMakeArithmeticProgression l = new LeetCode_CanMakeArithmeticProgression();
        int[] arr = {3,5,1};
        System.out.println(l.canMakeArithmeticProgression(arr));
    }
}
