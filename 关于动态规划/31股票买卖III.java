class Solution {

    /**
     * 123. 股票买卖III
     * 最经典简单的三维dp空间动态规划思想
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // dp定义：dp[i][0] 第i天不持有股票的总利润，dp[i][1]第i天持有股票的总利润
        int max_k = 2;
        int len = prices.length;
        int[][][] dp = new int[len+1][max_k+1][2];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= max_k; j++) {
                dp[i][j][1] = Integer.MIN_VALUE;
            }
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= max_k; j++) {
                // 今天不持有，表明要么昨天本身不持有，今天不进行操作；要么今天持有，但是刚好出售了，此时进行+操作。
                // 今天持有，表明要么昨天本身持有，今天不进行操作；要么今天不持有，但是刚好买入了，此时进行-操作。
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1]+prices[i-1]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0]-prices[i-1]);
            }
        }
        return dp[len][max_k][0];
    }
}

class Solution {
    /**
     * 由于max_k=2，因此可进行优化
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // dp定义：dp[i][0] 第i天不持有股票的总利润，dp[i][1]第i天持有股票的总利润
        int len = prices.length;
//        dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1]+prices[i-1]);
//        dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][0]-prices[i-1]);
//        dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][2][1]+prices[i-1]);
//        dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i-1][1][0]-prices[i-1]);
        // 根据以上四行进行优化
        int dp_i10 = 0;
        int dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0;
        int dp_i21 = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            dp_i10 = Math.max(dp_i10, dp_i11+prices[i]);
            dp_i11 = Math.max(dp_i11, -prices[i]);
            dp_i20 = Math.max(dp_i20, dp_i21+prices[i]);
            dp_i21 = Math.max(dp_i21, dp_i10-prices[i]);
        }
        return dp_i20;
    }
}
