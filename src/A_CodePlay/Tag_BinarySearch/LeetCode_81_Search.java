package A_CodePlay.Tag_BinarySearch;

/**
 * 81. 搜索旋转排序数组 II 中等
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
 * 如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * 示例 1：
 *
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 */
public class LeetCode_81_Search {

    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int mid;
        while (left <= right) {

            // 与 33 相比, 多了去重
            while (left < right && nums[left + 1] == nums[left]) {
                left++;
            }
            while (left < right && nums[right - 1] == nums[right]) {
                right--;
            }

            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] <= nums[right]) { // 右半边有序
                if (nums[mid] < target && target <= nums[right]) { // target 刚好落在右半边
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { // 左半边有序
                if (nums[left] <= target && target < nums[mid]) { // target 刚好落在左半边
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        System.out.println(new LeetCode_81_Search().search(nums, 3));
    }
}
