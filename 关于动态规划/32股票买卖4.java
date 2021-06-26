class Solution {
    /**
    *   
    *
    */
    public int maxProfit(int k, int[] prices) {
        // dp定义：dp[i][0] 第i天不持有股票的总利润，dp[i][1]第i天持有股票的总利润
        int max_k = k;
        int len = prices.length;
        int[][][] dp = new int[len+1][max_k+1][2];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= k; j++) {
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