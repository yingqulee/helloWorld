package A_CodePlay.Tag_Array;

/**
 * 747. 至少是其他数字两倍的最大数 简单
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 *
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 *
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 * 示例 1:
 *
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *  
 *
 * 示例 2:
 *
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 */
public class LeetCode_747_DominantIndex {

    public int dominantIndexI(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max == nums[i]) {
                index = i;
            } else if (max < nums[i] * 2) {
                return -1;
            }
        }
        return index;
    }

    //优化 如果我们找到第二大的元素，将它的两倍的值与最大值进行比较，不就能证明最大值是否大于所有元素两倍的值吗？
    public int dominantIndexII(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int max = -1, index = 0, less = 1;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                less = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > less) {
                less = nums[i];
            }
        }
        return max < (less * 2) ? -1 : index;
    }
    public static void main(String[] args) {
        LeetCode_747_DominantIndex l = new LeetCode_747_DominantIndex();
        int[] nums = {0, 0, 0, 1};
        System.out.println(l.dominantIndexII(nums));
    }
}
