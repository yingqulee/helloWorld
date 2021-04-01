package A_CodePlay.Tag_TwoPointer;

/**
 * 11. 盛最多水的容器 中等
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 *
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class LeetCode_11_MaxArea {

    /**
     * 使用双指针的原因是根据这个问题的特点，存水的高度取决于两边较短的那个内壁的高度。
     *
     * 使用指针对撞的方式不会错过最优解。
     *
     * 经验：双指针、滑动窗口的问题，一般先从暴力枚举开始思考，然后更改枚举的顺序，以达到剪枝加快计算的效果。
     * @param height
     * @return
     */
    private static int maxArea(int[] height){

        int max = 0;

        int left = 0, right = height.length - 1;
        while(left < right) {
            int minHeight = Math.min(height[left], height[right]);
            max = Math.max(max, minHeight * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }
}
