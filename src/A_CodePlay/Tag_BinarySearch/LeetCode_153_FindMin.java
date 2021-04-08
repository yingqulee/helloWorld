package A_CodePlay.Tag_BinarySearch;

/**
 * 153. 寻找旋转排序数组中的最小值 中等
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 */
public class LeetCode_153_FindMin {

    /**
     和 I 的做法类似, 都是二分法, 每次进入无序的那部分找出最小值
     但是由于有重复值的情况, 需要加入 mid 元素等于 hi 元素的情况
     此时应该将 hi 减 1 防止重复数字是最小元素
     **/
    public static int findMinII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }

    //前面一堆 0 ，后面一堆 1 ，然后寻找第一个１的二分问题
    public static int findMinI(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 这里有个编程技巧
            // 因为l < r 所以最后一轮肯定是(r, r+1)
            // 那么 mid 肯定是取值l 当判断条件是mid与l比时 会出现与自身比 造成出现等于情况 不好判断
            // 所以判断条件时mid 与 r比 这样肯定是不同的两个数比

            // mid大于左边边界或者小于左边边界，最小值都有可能落在这个区间，所以区分不了 一定要 nums[mid] <= nums[right]
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMinI(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMinII(new int[]{3,3,3,0,3}));
    }
}
