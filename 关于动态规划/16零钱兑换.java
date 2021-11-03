class Solution {
    /**
     * 322零钱兑换
     * 最基本的动态规划思想-自底向上
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        // 初始化为不可能达到的最大值，方便后续的最小值动归优化
        for (int i = 0; i < amount+1; i++) {
            dp[i] = amount+1;
        }
        dp[0] = 0;
        for (int i = 1; i < amount+1; i++) {
            for (int c: coins) {
                if (i >= c) {
                    dp[i] = Math.min(dp[i], dp[i-c] + 1);
                }
            }
        }
        // 进行判断：若最终值与初始值一致，则表明无解，返回-1。
        return dp[amount] == amount+1? -1: dp[amount];
    }
}