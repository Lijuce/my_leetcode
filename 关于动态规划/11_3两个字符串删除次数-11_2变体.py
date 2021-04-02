# 583. 两个字符串的删除操作


def minDistance(self, word1: str, word2: str) -> int:
    # 问题转化为求最长公共子序列
    def longestCommonSubsequence(text1: str, text2: str) -> int:
        length_a = len(word1)
        length_b = len(word2)

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
    

    common_length = longestCommonSubsequence(word1, word2)
    
    return (len(word1)-common_length) + (len(word2)-common_length)  # 得出最长公共子序长度后，再长度相减得到最终需要的删除操作次数