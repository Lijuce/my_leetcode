# 121. 买卖股票的最佳时机1

def maxProfit(prices: list) -> int:
    # 问题转化为：寻找一个无序数组中最大值，同时寻找出该最大值之前的最小值（若有最小值）
    # if len(prices) <= 1:
    #     return 0
    
    # min_p = prices[0]
    # max_p = 0
    # for i in range(1, len(prices)):
    #     min_p = min(min_p, prices[i])
    #     max_p = max(max_p, prices[i]-min_p)
    # return max_p

    # 动态规划法
    n = len(prices)  # 天数
    dp = [0]*n  # 第n天得到的股票收益最大
    min_p = prices[0]
    for i in range(1,n):
        min_p = min(min_p, prices[i])
        dp[i] = max(prices[i]-min_p, dp[i-1])
    return dp[-1]

print(maxProfit([1,6,4,3,1]))
