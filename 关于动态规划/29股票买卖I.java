class Solution {
    /**
     * 121. 买卖股票I
     * 简单动态规划解决
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
         int[] dp = new int[len];
         dp[0] = 0;
         int min = prices[0];
         for (int i = 1; i < len; i++) {
             min = Math.min(min, prices[i]);
             dp[i] = Math.max(dp[i-1], prices[i]-min);
         }
         return dp[len-1];
    }
}

class Solution2 {
    /**
     * 空间优化
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-min);
        }
        return maxProfit;
    }
}