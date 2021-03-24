# 188. 买卖股票的最佳时机 IV
# 最多完成2笔交易

def maxProfit(k: int, prices: list):
    n = len(prices)
    max_k = k
    if max_k > n//2:  # 交易完成至少花费2天
        max_k = n//2

    dp = [[[0 for i in range(2)] for j in range(max_k+1)] for k in range(n)]

    for i in range(n):
        for k in range(max_k, 0, -1):
            if i-1 == -1: # 处理base case
                dp[-1][k][0] = 0
                dp[-1][k][1] = -10000
                dp[i][0][0] = 0
                dp[i][0][1] = -10000
            dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+prices[i])
            dp[i][k][1] = max(dp[i-1][k][1], dp[i-2][k-1][0]-prices[i])  # 

    return dp[n - 1][max_k][0]
    
k = 2
prices = [3,2,6,5,0,3]
print(maxProfit(k,prices))


