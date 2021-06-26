public class Main {
    /**
     * 714. 买卖股票的最佳时机含手续费
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2)
            return 0;
        int dp[][] = new int[len][2];
        // dp初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);  // 第2天卖了后得到的利润
        dp[1][1] = Math.max(dp[0][1], -prices[1]);
        // dp[1][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]-fee);
            // 由于卖出股票后需冷冻一天才能再次买入股票，
            // 持有股票的两种情况：昨天本身持有股票/昨天不持有股票，然后今天买入，但必须确保第i-1天没有卖出，因此只能从i-2中进行状态转移
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return dp[len-1][0];
    }
}