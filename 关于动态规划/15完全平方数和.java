public int numSquares(int n) {
    // DP   思路类似于凑零钱
    int[] dp = new int[n+1];
    for (int i = 1; i <= n; i++){
        dp[i] = i;  // 最坏的情况，由n个1构成
        for (int j = 1; i - j*j >= 0; j++)  // 从1开始一个个尝试
            dp[i] = Math.min(dp[i], dp[i - j*j]+1);
    }
    return dp[n];
}

