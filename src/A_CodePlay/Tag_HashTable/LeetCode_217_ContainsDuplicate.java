package A_CodePlay.Tag_HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素 简单
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class LeetCode_217_ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        /*HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                 return true;
            }
            map.put(num,map.get(num));
        }
        return false;*/

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() == nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,1};
        System.out.println(containsDuplicate(nums));
    }
}
