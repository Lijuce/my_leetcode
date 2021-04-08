# 2021年4月8日
# 力扣热门100题之一
# 96. 不同的二叉搜索树


def numTrees(n: int) -> int:
    # 动态规划
    # 有待继续深入理解
    dp = [0] * (n+1)
    dp[0], dp[1] = 1, 1  # base case

    for i in range(2, n+1):
        for j in range(1, i+1):
            dp[i] += dp[j-1]*dp[i-j]
    return dp[n]