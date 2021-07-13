class Solution {
    /**
     * 63. 不同路径 II - 带有障碍物
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 起点就是障碍物，必定到不了终点
        if (obstacleGrid[0][0] == 1)
            return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 有障碍物的地点能到达的路径数为0
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if (i==0 && j==0)
                    continue;
                if (i == 0 || j == 0)
                    dp[i][j] = i==0?dp[0][j-1]: dp[i-1][0];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}