class Solution {
    int resMax = 0;

    /**
     * 329. 矩阵中的最长递增路径
     * 二维矩阵经典的DFS思想
     * (仍需多多理解。。。)
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        int[][] visited = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                // 已遍历过，无需再次遍历
                if (visited[i][j] > 0)
                    continue;
                resMax = Math.max(resMax, dfs(matrix, i, j, visited, Integer.MIN_VALUE));
            }
        return resMax;
    }

    private int dfs(int[][] matrix, int x, int y, int[][] visited, int lastVal) {
        // 越界直接返回0
        if (x < 0 || x > matrix.length-1 || y < 0 || y > matrix[0].length-1)
            return 0;
        // 非递增情况直接返回0
        if (matrix[x][y] <= lastVal)
            return 0;
        // 已经遍历过
        if (visited[x][y] > 0)
            return visited[x][y];

        // 四个方向扩展该节点
        int up = dfs(matrix, x-1, y, visited, matrix[x][y]);
        int down = dfs(matrix, x+1, y, visited, matrix[x][y]);
        int left = dfs(matrix, x, y-1, visited, matrix[x][y]);
        int right = dfs(matrix, x, y+1, visited, matrix[x][y]);
        visited[x][y] = 1 + Math.max(Math.max(up, down), Math.max(left, right));
        return visited[x][y];
    }
}