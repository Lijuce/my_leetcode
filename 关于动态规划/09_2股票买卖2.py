# 122. 买卖股票的最佳时机 II
# 无限次交易

def maxProfit(prices: list) -> int:
    n = len(prices)
    dp = [0]*n
    a,b,c = 0,0,0
    for i in range(1, n):  
        dp[i] = dp[i-1] + max(0, prices[i]-prices[i-1])


    return dp


print(maxProfit([1,2,3,0,2]))
