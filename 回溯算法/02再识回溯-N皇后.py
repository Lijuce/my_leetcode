# N皇后问题（难）  2021年3月27日  还需再理解

def solveNQueens(n):
    res = []
    board = [['.' for i in range(n)] for i in range(n)]

    def isValid(board, row, col):
        n = len(board)
        for i in range(n):  # 检查列是否有冲突
            if i == row:
                continue
            if board[i][col] == 'Q':
                return False
        for i,j in zip(range(row-1, -1, -1), range(col+1, n, 1)):  # 检查右上方是否冲突
            if board[i][j] == 'Q':
                return False
        for i,j in zip(range(row-1, -1, -1), range(col-1, -1, -1)):  # 检查左上方是否冲突
            if board[i][j] == 'Q':
                return False
        return True       

    def drawback(board, row):
        if len(board) == row:
            board = [''.join(b) for b in board]
            res.append(board)
            return

        n = len(board[row])
        for col in range(n):
            # 判断皇后放置是否合理
            if not isValid(board, row, col):
                continue
            # 做选择
            board[row][col] = 'Q'
            # 进入下一个决策
            drawback(board, row+1)
            # 撤销选择
            board[row][col] = '.'
        
    drawback(board, 0)
    return res

print(solveNQueens(n=4))



