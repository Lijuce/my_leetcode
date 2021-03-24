# 714. 买卖股票的最佳时机含手续费

def maxProfit(prices: list, fee: int):
    n = len(prices)
    if n < 2:
        return 0
    # 优化
    dp_i0 = 0
    dp_i1 = -10000

    for i in range(1,n):
        dp_i0 = max(dp_i0, dp_i1+prices[i]-fee)  # 最终卖出后（不再持有）最大利润
        dp_i1 = max(dp_i1, dp_i0-prices[i])  # 要在第i天买入，只有等第i-2天卖出结束才可进行
    return dp_i0

prices = [1, 3, 2, 8, 4, 9]
fee = 2
print(maxProfit(prices, fee))
