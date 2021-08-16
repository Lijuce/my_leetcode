class Solution {
    /**
     * 完全背包问题-零钱兑换II
     * 注意此处的硬币是无限量获取的
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int cLen = coins.length;
        // dp定义：前i个硬币，能够凑出j金额的方式共dp[i][j]种
        int[][] dp = new int[cLen+1][amount+1];
        // dp初始化。
        for (int i = 0; i < cLen + 1; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i < cLen + 1; i++){
            for (int j = 1; j < amount + 1; j++) {
                if (j - coins[i-1] >= 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[cLen][amount];
    }
}

class Solution2 {
    /**
     * 优化版本-二维dp可压缩至一维
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int cLen = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = 0; i < cLen + 1; i++){
            for (int j = 1; j < amount + 1; j++) {
                if (j - coins[i-1] >= 0){
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }
        }
        return dp[amount];
    }
}

