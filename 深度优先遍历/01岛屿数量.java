class Solution {
    /**
     * 200. 岛屿数量
     * 经典的深度优先遍历思想
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int xLen = grid.length;
        int yLen = grid[0].length;

        int islandNums = 0;
        for (int i = 0; i < xLen; i++)
            for (int j = 0; j < yLen; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islandNums ++;
                }
            }
        return islandNums;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1')
            return;
        // 标记为已扫描过
        grid[i][j] = '2';
        // 上下左右四个方向各扫描一遍
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}