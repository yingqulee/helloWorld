package A_CodePlay.Tag_Array;

import java.util.Arrays;

/**
 * 189. 旋转数组 中等
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 */
public class LeetCode_RotateArray {

    //三次交换
    public void rotateI(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        swap(nums,0, len - k - 1);
        swap(nums, len - k, len - 1);
        swap(nums, 0, len - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void swap(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    /**
     * 环状替换
     * 从位置 00 开始，最初令 temp = nums[0]。根据规则，位置 0 的元素会放至 (0+k) mod n 的位置，
     * 令 x = (0+k) mod n，此时交换 temp 和 nums[x]，完成位置 x 的更新。
     * 然后，我们考察位置 x，并交换 temp 和 nums[(x+k) mod n]，从而完成下一个位置的更新。
     * 不断进行上述过程，直至回到初始位置 0。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/
     */
    public void rotateII(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
        System.out.println(Arrays.toString(nums));
    }
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        LeetCode_RotateArray l = new LeetCode_RotateArray();
        l.rotateII(nums, 2);
    }
}
