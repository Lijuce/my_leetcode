class Solution {
    /**
     * 64. 最小路径和
     * 自底向上的动态规划
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int xLen = grid.length;
        int yLen = grid[0].length;
        // dp定义：dp[i][j]对应第i行第j列所对应的路径和最小值
        int[][] dp = new int[xLen][yLen];
        // 初始化
        dp[0][0] = grid[0][0];
        for (int i = 1; i < xLen; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < yLen; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < xLen; i++) {
            for (int j = 1; j < yLen; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[xLen-1][yLen-1];
    }
}