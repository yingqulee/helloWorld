package A_CodePlay.Tag_HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和 简单
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class LeetCode_1_TwoSum {
    
    //暴力解法
    public static int[] twoSum01(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]){
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("NULL");
    }
    
    //两遍哈希表
    public static int[] twoSum02(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int ans = target - nums[i];
            if (map.containsKey(ans) && map.get(ans) != i) {
                return new int[] { i, map.get(ans) };
            }
        }
        throw new IllegalArgumentException("NULL");
    }
    
    //一遍哈希表
    public static int[] twoSum03(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int ans = target - nums[i];
            if(map.containsKey(ans)){
                return new int[] {map.get(ans),i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("NULL");
    }

    public static void main(String[] args) {
        int a[] = {2,2,4,6};
        int[] sum = twoSum03(a, 6);
        for (int i : sum) {
            System.out.println(i);
        }
    }

}
