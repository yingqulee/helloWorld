package A_LeetCodeContest;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 A，请找出并返回在该数组中仅出现一次的最大整数。
 *
 * 如果不存在这个只出现一次的整数，则返回 -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[5,7,3,9,4,9,8,3,1]
 * 输出：8
 * 解释：
 * 数组中最大的整数是 9，但它在数组中重复出现了。而第二大的整数是 8，它只出现了一次，所以答案是 8。
 * 示例 2：
 *
 * 输入：[9,9,8,8]
 * 输出：-1
 * 解释：
 * 数组中不存在仅出现一次的整数。
 */
public class Contest_LargestUniqueNumber {

    public static int largestUniqueNumber(int[] nums) {
        if (nums == null) return 0;

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],0);
            }
        }

        int max = -1;
        for (int key : map.keySet()) {
             if (map.get(key) == 0){
                 max = Math.max(max,key);
             }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {8,8,9,9};
        System.out.println(largestUniqueNumber(nums));
    }
}
