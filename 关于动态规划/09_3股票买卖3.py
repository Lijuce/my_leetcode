# 123. 买卖股票的最佳时机 III
# 最多完成2笔交易

def maxProfit(prices: list):
    n = len(prices)
    max_k = 2
    # # 状态转移---i：第i天   k:交易次数  0:不持有 1:持有
    # dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+prices[i])  # 本身并无持有并且没有操作，或者刚好已卖出
    # dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i])  # 本身持有但没有操作，或者刚好已买入
    dp = [[[0 for i in range(2)] for j in range(max_k+1)] for k in range(n)]
    for i in range(n):
        for k in range(max_k, 0, -1):
            if i-1 == -1: # 处理base case
                dp[-1][k][0] = 0
                dp[-1][k][1] = -10000
                dp[i][0][0] = 0
                dp[i][0][1] = -10000
            dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+prices[i])
            dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i])

    return dp[n - 1][max_k][0]
    
    # dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1]+prices[i])
    # dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0]-prices[i])
    # dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1]+prices[i])
    # dp[i][1][1] = max(dp[i-1][1][1], -prices[i])
    # 空间优化
    dp_i10 = 0
    dp_i11 = -10000
    dp_i20 = 0
    dp_i21 = -10000
    for p in prices:
        dp_i20 = max(dp_i20, dp_i21+p)
        dp_i21 = max(dp_i21, dp_i10-p)
        dp_i10 = max(dp_i10, dp_i11+p)
        dp_i11 = max(dp_i11, -p)

    return dp_i20


print(maxProfit([3,3,5,0,0,3,1,4]))