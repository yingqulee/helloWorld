package A_CodePlay.Tag_SlidingWindow;

import java.util.*;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值 困难
 *
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 */
public class NewCoder_MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if (i > 0 && deque.peekFirst() == nums[i - 1]) {
                deque.removeFirst(); // 删除 deque 中对应的 nums[i-1]
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast(); // 保持 deque 递减
            }
            deque.addLast(nums[j]);
            if (i >= 0) {
                res[i] = deque.peekFirst();  // 记录窗口最大值
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        NewCoder_MaxSlidingWindow n = new NewCoder_MaxSlidingWindow();
        System.out.println(Arrays.toString(n.maxSlidingWindow(nums, 3)));
    }
}