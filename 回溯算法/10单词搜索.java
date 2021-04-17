// 79. 单词搜索

class Solution {
    // 偏移量数组设定(小技巧)
    int[][] Directions = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board.length <= 0) return false;

        visited = new boolean[board.length][board[0].length]; // 设置不重复

        // char[] charArray = word.toCharArray();
        for (int i=0; i<board.length; i++)
            for (int j=0; j<board[0].length; j++){
                if (backTrack(board, word, 0, i, j))
                    return true;
            }
        return false;
    }

    public boolean backTrack(char[][] board, String word, int point, int x, int y){
        if (point == word.length()-1){
            // return board[x][y] == word[point];
            return board[x][y] == word.charAt(point);
        }
        if (board[x][y] == word.charAt(point)){  // 核心部分
            visited[x][y] = true;
            for (int[] d: Directions){  // 4个方向每个都做一次选择
                int newX = x + d[0];
                int newY = y + d[1];
                if (newX>=0 && newX<board.length && newY>=0 && newY<board[0].length && !visited[newX][newY]){
                    if(backTrack(board, word, point+1, newX, newY))  // 遇到相同字符，指针数值自增1
                        return true;
                }   
            }
            visited[x][y] = false;
        }
        return false;
    }
}