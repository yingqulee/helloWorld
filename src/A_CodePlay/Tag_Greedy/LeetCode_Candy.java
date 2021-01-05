package A_CodePlay.Tag_Greedy;

/**
 * 135. 分发糖果 困难
 *
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,0,2]
 * 输出：5
 * 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 *
 * 输入：[1,2,2]
 * 输出：4
 * 解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 */
public class LeetCode_Candy {

    //总体思路: 每个孩子的左右边都要考虑;
    public static int candy(int[] ratings) {
        int res = 0;
        int[] candies = new int[ratings.length]; //记录每位学生的糖果数
        candies[0] = 1;
        //先正序遍历，如果后一位比前一位高分，就给比前一位多1的糖果，否则给1
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        //在倒叙遍历，如果前一位比后一位高分并且得到的糖果小于或等于后一位，就给前一位孩子比后一位孩子多一个糖果
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) {
                candies[i] = candies[i+1] + 1;
            }
        }
        for (int candy : candies) {
            res += candy;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));
    }
}
