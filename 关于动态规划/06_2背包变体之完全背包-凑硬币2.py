# 518. 零钱兑换 II
# 转化为完全背包问题

coins = [1,2,5]
amount = 5

length = len(coins)
# dp = [[0 for i in range(amount+1)] for j in range(length+1)]

# # base case
# for i in range(length+1):
#     dp[i][0] = 1

# for i in range(1, length+1):
#     for j in range(1, amount+1):
#         if j-coins[i-1] < 0:
#             dp[i][j] = dp[i-1][j]
#         else:
#             dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
# return dp[length][amount]

# 优化此法（空间复杂度）
dp = [0 for i in range(amount+1)]
dp[0] = 1  # base case
for i in range(length):
    for j in range(1, amount+1):  # 上面base case明示，因此从amount=1开始遍历
        if j - coins[i] >= 0:
            dp[j] = dp[j] + dp[j-coins[i]]

print(dp[amount])
