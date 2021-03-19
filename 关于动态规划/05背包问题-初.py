# 0-1背包问题
# 2021年3月18日 还没彻底理解

import numpy as np  

wt = [2,1,3]  # 各物品重量
val = [4,2,3]  # 各物品价值
N = len(wt)  # 物品个数
W = 4  # 背包容量

# dp = [[0]*(W+1)] * (N+1)  # DP table   注： python 不能如此定义二维数组
# dp = np.zeros((N+1, W+1), dtype=int)


# for i in range(1, N+1):  # 1~3
#     for w in range(1, W+1):  # 1~4
#         if w-wt[i-1] < 0:  # 背包容量不足，保存之前的物品总价值
#             dp[i][w] = dp[i-1][w]
#         else:
#             dp[i][w] = max(dp[i-1][w], dp[i-1][w-wt[i-1]]+val[i-1])  # 装包与否，择优决定

dp = [0 for i in range(W+1)]
dp[0] = 0

for i in range(N):
    for w in range(W, -1, -1):
        if w-wt[i] >= 0:
            dp[w] = max(dp[w-1], dp[w-wt[i]]+val[i])
        
    # for w in range(1, W+1):
        # if w-wt[i] < 0:
        #     dp[w] = dp[w-1]
        # else:
        #     dp[w] = max(dp[w-1], dp[w-wt[i]]+val[i])
        # if w-wt[i] >= 0:
        #     dp[w] = max(dp[w-1], dp[w-wt[i]]+val[i])

print(dp)
