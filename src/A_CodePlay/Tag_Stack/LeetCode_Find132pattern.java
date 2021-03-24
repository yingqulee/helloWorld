package A_CodePlay.Tag_Stack;

import java.util.LinkedList;

/**
 * 456. 132模式 中等
 *
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 * 注意：n 的值小于15000。
 *
 * 示例1:
 *
 * 输入: [1, 2, 3, 4]
 *
 * 输出: False
 *
 * 解释: 序列中不存在132模式的子序列。
 * 示例 2:
 *
 * 输入: [3, 1, 4, 2]
 *
 * 输出: True
 *
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 * 示例 3:
 *
 * 输入: [-1, 3, 2, 0]
 *
 * 输出: True
 *
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/132-pattern
 */
public class LeetCode_Find132pattern {

    //使用栈
    public boolean find132patternI(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        LinkedList<Integer> stack = new LinkedList<>(); // 用来存储132中的3
        int last = Integer.MIN_VALUE; // 132中的2
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < last) { // 如果1<2，且中间必有个3
                return true;
            }
            // 若当前值大于或等于2则更新2（2为栈中小于当前值的最大元素）
            // 注意这个栈一定是个单调递增的栈，栈顶元素一定是最小的
            // 因为如果某个元素比栈顶元素大，那么栈顶元素就会被弹出。
            // 所以到最后，栈内元素一定是从栈顶到栈底递增的。
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                last = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    //模拟 找132中的2
    public boolean find132patternII(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int one = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < one) {
                one = nums[i];
            } else {
                int three = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    three = Math.max(three, nums[j]);
                    if (nums[j] > one && nums[j] < three) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode_Find132pattern l = new LeetCode_Find132pattern();
        int[] nums = {-1, 3, 2, 0};
        System.out.println(l.find132patternI(nums));
    }
}
