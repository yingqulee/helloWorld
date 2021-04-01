package A_CodePlay.Tag_Array;

import java.util.Arrays;

/**
 * 169. 多数元素 简单
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class LeetCode_169_MajorityElement {

    //Boyer-Moore 投票算法
//    public static int majorityElement(int[] nums) {
//        int ans = nums[0];
//        int count = 1;
//
//        for (int num : nums) {
//            if (ans != num) {
//                count--;
//                if (count == 0) {//减到0重新开始下一个数
//                    count = 1;
//                    ans = num;
//                }
//            }
//            else {
//                count++;
//            }
//
//        }
//        return ans;
//    }

    //API : 在数组中出现次数大于 ⌊ n/2 ⌋ 的元素
    public static int majorityElements(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElements(nums));
    }
}
