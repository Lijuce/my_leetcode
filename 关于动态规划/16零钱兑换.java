class Solution {
    /**
     * 322零钱兑换
     * 最基本的动态规划思想-自底向上
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i = 0; i < dp.length; i++)
            dp[i] = amount+1;
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            for (int c: coins){
                if (i - c < 0)
                    continue;
                dp[i] = Math.min(dp[i], dp[i-c] + 1);
            }
        }
        return (dp[amount] == amount+1) ? -1: dp[amount];

    }
}