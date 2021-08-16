class solution {
    /**
     * 剑指 Offer 13. 机器人的运动范围
     * 法一：利用DFS思想，将所有可能的情况考虑进去，然后进行递归
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0,0,m,n,k,visited);
    }

    private int dfs(int x, int y, int m, int n, int k, boolean[][] visited) {
        if (x < 0 || x >= m || y < 0 || y >= n || (x/10+x%10+y/10+y%10) >k || visited[x][y]) {
            return 0;
        }
        // 记录经过的点
        visited[x][y] = true;
        return dfs(x+1,y,m,n,k,visited) + dfs(x,y+1,m,n,k,visited)
                + dfs(x-1,y,m,n,k,visited) + dfs(x,y-1,m,n,k,visited)
                + 1;
    }
}