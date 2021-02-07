package A_CodePlay.Tag_Array;

/**
 * 665. 非递减数列 简单
 *
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 */
public class LeetCode_CheckPossibility {

    public boolean checkPossibilityI(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return true;
        }
        int count = 0;
        for (int i = 1; i < nums.length && count < 2; i++) {
            if (nums[i - 1] <= nums[i]) {
                continue;
            }
            count++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return count <= 1;
    }

    // 思路如下：
    // 如果出现 a[i] > a[i+1]   改变一个数 就面临两种选择
    // 1. 把a[i]变大
    // 2. 把a[i+1] 变小
    // 这两种选择其实是有依据的 需要比较a[i-1] 与 a[i+1]的值
    // eg.  ... 1 4 3 ...   只能选择把4变小   ... 3 4 1 ... 只能选择把1变大
    // 改变完之后，记录改变次数，再检测是否升序
    // 如果次数大于1，至少改了两次 返回false
    public boolean checkPossibilityII(int[] nums) {
        int n = nums.length, count = 0;
        for (int i = 0; i < n - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                count++;
                if (count > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,3};
        LeetCode_CheckPossibility l = new LeetCode_CheckPossibility();
        System.out.println(l.checkPossibilityII(nums));
    }
}
