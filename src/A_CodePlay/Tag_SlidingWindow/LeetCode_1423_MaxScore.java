package A_CodePlay.Tag_SlidingWindow;

/**
 * 1423. 可获得的最大点数 中等
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 *
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 *
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 *
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 *
 * 示例 1：
 *
 * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
 * 输出：12
 * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
 * 示例 2：
 *
 * 输入：cardPoints = [2,2,2], k = 2
 * 输出：4
 * 解释：无论你拿起哪两张卡牌，可获得的点数总是 4 。
 * 示例 3：
 *
 * 输入：cardPoints = [9,7,7,9,7,7,9], k = 7
 * 输出：55
 * 解释：你必须拿起所有卡牌，可以获得的点数为所有卡牌的点数之和。
 * 示例 4：
 *
 * 输入：cardPoints = [1,1000,1], k = 1
 * 输出：1
 * 解释：你无法拿到中间那张卡牌，所以可以获得的最大点数为 1 。
 * 示例 5：
 *
 * 输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
 * 输出：202
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards
 */
public class LeetCode_1423_MaxScore {

    //维护一个len-k的窗口，保证窗口里面和最小，然后剩余的k个数的和就是最大
    public int maxScoreI(int[] cardPoints, int k) {
        int sum = 0, len = cardPoints.length;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int max = sum;
        //滑动窗口
        for (int i = 0; i < k; i++) {
            sum += cardPoints[len - 1 - i] - cardPoints[k - 1 - i];
            max = Math.max(sum, max);
        }
        return max;
    }

    //维护一个len-k的窗口，保证窗口里面和最小，然后剩余的k个数的和就是最大
    public int maxScoreII(int[] cardPoints, int k) {
        int sum = 0, len = cardPoints.length;
        for (int i = 0; i < len; i++) {
            sum += cardPoints[i];
        }
        int min = Integer.MAX_VALUE, temp = 0;
        int window = len - k;
        for (int i = 0; i < len; i++) {
            temp += cardPoints[i];
            if (i >= window) {
                temp -= cardPoints[i - window];
            }
            if (i >= window - 1) {
                min = Math.min(min, temp);
            }
        }
        return sum - min;
    }

    public static void main(String[] args) {
        int[] cardPoints = {1,79,80,1,100,1,200,1};
        LeetCode_1423_MaxScore leetCode_maxScore = new LeetCode_1423_MaxScore();
        System.out.println(leetCode_maxScore.maxScoreI(cardPoints, 3));
    }
}
