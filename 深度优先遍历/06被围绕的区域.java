class Solution {
    /**
     * 130. 被围绕的区域
     * 同样是经典的深度遍历优先思想
     * 从边界进行扩展，从而使得问题转化为 200.岛屿数量 问题
     * @param board
     */
    public void solve(char[][] board) {
        int xLen = board.length;
        int yLen = board[0].length;

        for (int i = 0; i < xLen; i++)
            for (int j = 0; j < yLen; j++) {
                boolean isEdge = (i == 0 || j == 0 || i == xLen-1 || j == yLen-1);
                if (isEdge && board[i][j] == 'O')
                    dfs(board, i, j);
            }

        for (int i = 0; i < xLen; i++)
            for (int j = 0; j < yLen; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '-')
                    board[i][j] = 'O';
            }
        return ;
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '-' || board[x][y] == 'X')
            return;

        board[x][y] = '-';
        // 上下左右四个方向
        dfs(board, x+1, y);
        dfs(board, x-1, y);
        dfs(board, x, y+1);
        dfs(board, x, y-1);
    }
}