class Solution {
    /**
     * 背包问题-最简单版
     * @return
     */
    public int bagProblem(){
        int[] wt = new int[] {2,1,3};
        int[] val = new int[] {4,2,3};
        int N = wt.length;
        int W = 4;

        // DP定义：对于前i个物品，当前背包的容量为w，这种情况下可以装的最大价值是dp[i][w]。
        int[][] dp = new int[N+1][W+1];
        for (int i = 1; i < N+1; i++) {
            for (int w = 1; w < W + 1; w++) {
                // 装不下该物品，则最大价值量与前一个相同;
                // 装得下该物品，则
                if (w - wt[i-1] < 0)
                    dp[i][w] = dp[i-1][w];
                else
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-wt[i-1]] + val[i-1]);
            }
        }
        return dp[N][W];
    }
}