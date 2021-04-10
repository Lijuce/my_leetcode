# 2021年4月10日
# 力扣热门100题之一
# 312. 戳气球

def maxCoins(nums) -> int:
    n = len(nums)
    points = [0] * (n+2)  # 添加两侧的虚拟气球
    points[0] = points[n+1] = 1  # 对应超出边界的气球硬币为1

    for i in range(1, n+1):
        points[i] = nums[i - 1]

    dp = [[0 for i in range(n+2)] for j in range(n+2)]
    # 核心思想：考虑最后戳破的气球是哪一个，以此构建状态转移方程
    for i in range(n, -1, -1):  # i 从下往上遍历
        for j in range(i+1, n+2):  # j 从左往右遍历
            for k in range(i+1, j):  # 最后戳破的气球是哪个？
                dp[i][j] = max(dp[i][j], dp[i][k] + dp[k][j] + points[i]*points[j]*points[k])  # 择优做选择
    
    return dp[0][n+1]

