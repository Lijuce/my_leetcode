class Solution {
    /**
     * 剑指 Offer 14- I. 剪绳子
     * 方法一：动态规划。
     * 核心思想：减完后，是继续减还是减到为止，由此确定状态转移方程
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        // dp定义：长度为i的绳子，其最大乘积为dp[i]
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n+1; i++) {
            // j<=i/2+1是因为10分为3+7和7+3结果是一样的，可以略过
            for (int j = 2; j <= i/2+1; j++) {
                // 减去j长度，剩余i-j长度
                // i-j长度继续减，则为dp[i-j]
                // i-j不减则最终长度直接为j*(i-j)
                // 最后，对所有不同的剪法做比较，选择最大的那个
                dp[i] = Math.max(Math.max(j*dp[i-j], j*(i-j)), dp[i]);
            }
        }
        return dp[n];
    }
}