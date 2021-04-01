package A_CodePlay.Tag_DynamicProgramming;

/**
 * 动态规划版:
 *
 * base case：
 * dp[-1][k][0] = dp[i][0][0] = 0
 * dp[-1][k][1] = dp[i][0][1] = -infinity
 *
 * 状态转移方程：
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 *
 */
public class LeetCode_121_MaxProfit {
    /**121. 买卖股票的最佳时机
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * 示例 2:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */
    public int maxProfitI(int[] prices) {
//        if(prices.length <= 1){
//            return 0;
//        }
//
//        int min = prices[0], max = 0;
//        for(int i = 1; i < prices.length; i++){
//            max = Math.max(max, prices[i] - min);
//            min = Math.min(min, prices[i]);
//        }
//        return max;

        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }
    /** 122. 买卖股票的最佳时机 II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * @param prices
     * @return
     */
    private int maxProfitII(int[] prices) {
        if(prices.length == 0) return 0;
        int cur = prices[0];
        int sum = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                sum += prices[i] - prices[i-1];
            }
        }
        return sum;
    }

    /**123. 买卖股票的最佳时机 III
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     *
     * 输入: [3,3,5,0,0,3,1,4]
     * 输出: 6
     * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     * 示例 2:
     *
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
     * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
     * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     */
    public static int maxProfitIII(int[] prices) {
//        if(prices.length <= 1){
//            return 0;
//        }
//
//        int stock1 = Integer.MIN_VALUE, release1 = 0;    //The maximum if buy 1st stock and The maximum if sold 1st stock
//        int stock2 = Integer.MIN_VALUE, release2 = 0;    //The maximum if buy 2nd stock and The maximum if sold 2nd stock
//        for (int num : prices) {
//            release2 = Math.max(release2, stock2 + num); // The maximum if we've just sold 2nd stock so far.
//            stock2   = Math.max(stock2, release1 - num); // The maximum if we've just buy  2nd stock so far.
//            release1 = Math.max(release1, stock1 + num); // The maximum if we've just sold 1nd stock so far.
//            stock1   = Math.max(stock1, -num);           // The maximum if we've just buy  1st stock so far.
//        }
//        return release2;                                 //Since release1 is initiated as 0, so release2 will always higher than release1.
        /**状态转移方程:(第K次 -- k = 2)
         * 原始的动态转移方程，没有可化简的地方
         * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
         * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
         */
        int k = 2;
        int[][] dp = new int[k+1][prices.length];
        for (int n = 1; n <= k; n++) {
            int curMax = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[n][i] = Math.max(dp[n][i-1], prices[i] + curMax);
                curMax   = Math.max(curMax, dp[n-1][i-1] - prices[i]);
            }
        }
        return dp[k][prices.length-1];
    }

    /**188.买卖股票的最佳时机 IV
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     *
     * 输入: [2,4,1], k = 2
     * 输出: 2
     * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
     * 示例 2:
     *
     * 输入: [3,2,6,5,0,3], k = 2
     * 输出: 7
     * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
     */
    public int maxProfitIV(int k, int[] prices) {
        int len = prices.length;
        if (k >= (len/2)) {
            return maxProfitII(prices);
        }

        int[][] dp = new int[k+1][prices.length];
        for (int n = 1; n <= k; n++) {
            int curMax = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[n][i] = Math.max(dp[n][i-1], prices[i] + curMax);
                curMax   = Math.max(curMax, dp[n-1][i-1] - prices[i]);
            }
        }
        return dp[k][prices.length-1];
    }

    /**309. 最佳买卖股票时机含冷冻期
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 示例:
     *
     * 输入: [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     */
    public int maxProfitV(int[] prices) {
        /**状态转移方程:(含有冷却时期)
         * 每次 sell 之后要等一天才能继续交易。只要把这个特点融入上一题的状态转移方程即可：
         * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
         * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
         * 解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
         */
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0; // 代表 dp[i-2][0]
        for (int i = 0; i < prices.length; i++) {
            int cur = dp_i_0;

            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);

            dp_pre_0 = cur;
        }
        return dp_i_0;
    }

    /**714. 买卖股票的最佳时机含手续费
     * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
     * 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     * 返回获得利润的最大值。
     *
     * 示例 1:
     *
     * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
     * 输出: 8
     * 解释: 能够达到的最大利润:
     * 在此处买入 prices[0] = 1
     * 在此处卖出 prices[3] = 8
     * 在此处买入 prices[4] = 4
     * 在此处卖出 prices[5] = 9
     * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     */
    public int maxProfitVI(int[] prices, int fee) {
        /**状态转移方程:(含手续费)
         * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
         * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
         * 解释：相当于买入股票的价格升高了。
         * 在第一个式子里减也是一样的，相当于卖出股票的价格减小了。
         */
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int cur = dp_i_0;

            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
            dp_i_1 = Math.max(dp_i_1, cur - prices[i] - fee);
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        System.out.println(maxProfitIII(new int[]{3,3,5,0,0,3,1,4}));
    }
}
