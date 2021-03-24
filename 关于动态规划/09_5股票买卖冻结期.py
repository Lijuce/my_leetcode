# 309. 最佳买卖股票时机含冷冻期

def maxProfit(prices: list):
    n = len(prices)
    if n < 2:
        return 0
    # dp = [[0 for i in range(2)] for k in range(n)]
    # for i in range(n):
    #     if i-1 == -1: # 处理base case
    #         dp[-1][0] = 0
    #         dp[-1][1] = -10000
    #         dp[i][0] = 0
    #         dp[i][1] = -10000
    #     dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
    #     dp[i][1] = max(dp[i-1][1], dp[i-2][0]-prices[i])  # 第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
    # return dp[n - 1][0]

    # 优化
    dp_i0 = 0
    dp_i1 = -10000
    dp_i2 = 0

    for i in range(n):
        tmp = dp_i0
        dp_i0 = max(dp_i0, dp_i1+prices[i])  # 最终卖出后（不再持有）最大利润
        dp_i1 = max(dp_i1, dp_i2-prices[i])  # 要在第i天买入，只有等第i-2天卖出结束才可进行
        dp_i2 = tmp

    return dp_i0

print(maxProfit([1,2,3,0,2]))
