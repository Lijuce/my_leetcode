# 1143. 最长公共子序列  2021年4月2日
# 动态规划

def longestCommonSubsequence(text1: str, text2: str) -> int:
    length_a = len(text1)
    length_b = len(text2)

    dp = [[0 for i in range(length_a+1)] for i in range(length_b+1)]

    # base case
    for i in range(length_a+1):
        dp[0][i] = 0
    for i in range(length_b+1):
        dp[i][0] = 0

    for i in range(1, length_b+1):
        for j in range(1, length_a+1):
            if text2[i-1] == text1[j-1]:
                dp[i][j] = dp[i-1][j-1] + 1
            else:
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])  # 通过画表格得出
            
    return dp[length_b][length_a]