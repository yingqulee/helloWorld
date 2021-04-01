package A_CodePlay.Tag_HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 347. 前 K 个高频元素 中等
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class LeetCode_347_TopKFrequent {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            } else {
                map.put(num,1);
            }
        }

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(list[i] == null){
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
        for(int i = list.length - 1;i >= 0 && ans.size() < k;i--){
            if(list[i] == null) continue;
            ans.addAll(list[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,2,3,3,3,3,3,3,6,6,6,4,4,4,4,4,4,9,7,7,7};
        System.out.println(topKFrequent(nums,3));
    }
}
