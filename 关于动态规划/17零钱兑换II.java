class Solution {
    /**
     * 518. 零钱兑换 II
     * 完全背包问题(需多多理解)
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        for (int i = 0; i < dp.length; i++)
            dp[i] = 0;
        dp[0] = 1;
        int coinsSize = coins.length;
        for (int i = 0; i < coinsSize; i++){
            for (int j = coins[i]; j < amount+1; j++){
                dp[j] += dp[j-coins[i]];   
            }
        }
        return dp[amount];
    }
}