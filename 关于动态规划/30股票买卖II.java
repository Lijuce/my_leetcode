class Solution {
    /**
     * 122. 股票买卖II
     * 无限笔交易
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // dp定义：dp[i][0] 第i天不持有股票的总利润，dp[i][1]第i天持有股票的总利润
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }
}



