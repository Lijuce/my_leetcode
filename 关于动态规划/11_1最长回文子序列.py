# 2021年4月2日----还未能很好理解
# 516. 最长回文子序列

def longestPalindromeSubseq(s: str) -> int:   
    n = len(s)
    dp = [[0 for i in range(n)] for i in range(n)]
    # dp 数组全部初始化为 0
    for i in range(n):  # base case
        dp[i][i] = 1   # 只有一个字符，最长回文子序列长度是 1

    for i in range(n-1, -1, -1):
        for j in range(i+1, n):
            if s[i] == s[j]:    
                dp[i][j] = dp[i+1][j-1] + 2  # 它俩一定在最长回文子序列中
            else:
                dp[i][j] = max(dp[i+1][j], dp[i][j-1])  # s[i+1..j] 和 s[i..j-1] 谁的回文子序列更长？
    
    return dp[0][n-1]
