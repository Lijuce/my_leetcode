def minDistance(self, word1: str, word2: str) -> int:
    # 备忘录+递归法
    # memo = {}  # 备忘录

    # def dp(i, j):
    #     if (i, j) in memo:
    #         return memo[(i, j)]

    #     # base case 
    #     if i == -1:
    #         return j+1
    #     if j == -1:
    #         return i+1
        
    #     if word1[i] == word2[j]:  # 两个字母相同，两个指针同时向前移动
    #         # return dp(i-1, j-1)
    #         memo[(i, j)] = dp(i-1, j-1)
    #     else:
    #         # return min(
    #         #         dp(i, j-1)+1,  # 插入操作
    #         #         dp(i-1, j)+1,  # 删除
    #         #         dp(i-1, j-1)+1  # 替换
    #         #     )
    #         memo[(i, j)] =  min(
    #                         dp(i, j-1)+1,  # 插入操作
    #                         dp(i-1, j)+1,  # 删除
    #                         dp(i-1, j-1)+1  # 替换
    #                     )
    #     return memo[(i, j)]
    # return dp(len(word1)-1, len(word2)-1)

    # 动态规划法
    m = len(word1)
    n = len(word2)

    dp = [[0 for i in range(n+1)] for j in range(m+1)]
    # base case
    for i in range(1, m+1):
        dp[i][0] = i
    for i in range(1, n+1):
        dp[0][i] = i
    
    for i in range(1, m+1):
        for j in range(1, n+1):
            if word1[i-1] == word2[j-1]:
                dp[i][j] = dp[i-1][j-1]
            else:
                dp[i][j] = min(
                    dp[i][j-1] + 1,
                    dp[i-1][j] + 1,
                    dp[i-1][j-1] + 1
                )
    return dp[m][n]
