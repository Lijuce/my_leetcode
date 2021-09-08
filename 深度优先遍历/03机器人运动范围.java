class Solution {
    /**
     * 剑指 Offer 13. 机器人的运动范围
     * 经典的深度遍历优先思想（简单直接）
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0,0,m,n,visited,k);
    }

    private int dfs(int x, int y, int m, int n, boolean[][] visited, int k) {
        // 3种情况无法继续行走
        // 1. 越界
        // 2. 总和大于K
        // 3. 曾经过该点
        if (x < 0 || x >= m || y < 0 || y >= n || (x/10+x%10+y/10+y%10) > k || visited[x][y]) {
            return 0;
        }

        // 记录经过该点
        visited[x][y] = true;
        // 上下左右四个方向都走一遍
        // 不要忘记走过的路是要+1的
        return dfs(x+1, y, m, n, visited, k) +
                dfs(x-1, y, m, n, visited, k) +
                dfs(x, y+1, m, n, visited, k) +
                dfs(x, y-1, m, n, visited, k) +
                1;
    }
}