# 2021年4月10日
# 力扣热门100题之一
# 64. 最小路径和

def minPathSum(grid) -> int:
    # 自底向上迭代的动态规划
    m = len(grid)
    n = len(grid[0])
    dp = [[0 for i in range(n)] for j in range(m)]
    dp[0][0] = grid[0][0]  # base case
    
    for i in range(1, m):  # base case初始化两边显而易见的路径之和
        dp[i][0] = dp[i-1][0] + grid[i][0]
    for i in range(1, n):
        dp[0][i] = dp[0][i-1] + grid[0][i]

    for i in range(1, m):
        for j in range(1, n):
            dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]  # 每个路径（点）的最小值只有两个选择，即下边和右边（从左-右，上-下的顺序来看）

    return dp[m-1][n-1]