import java.util.Arrays;

class Solution {
    /**
     * 221. 最大正方形
     * 经典的二维dp空间动归思想
     * TODO: 可进行空间优化
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int xLen = matrix.length;
        int yLen = matrix[0].length;

        if (xLen < 1) {
            return 0;
        }
        // dp空间数组定义：以坐标点(i,j) 为右下角的最大正方形，而非区域中最大正方形
        int[][] dp = new int[xLen+1][yLen+1];
        // 以正方形右下角为关键节点，计算出其最大长度
        int res = 0;
        for (int i = 1; i < xLen+1; i++) {
            for (int j = 1; j < yLen+1; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        return res * res;
    }
}