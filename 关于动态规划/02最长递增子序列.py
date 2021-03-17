# 300 最长递增子序列

def lengthOfLIS(nums):

    dp = len(nums) * [1]  # base case  本身也是一个子序列                        

    for i in range(len(nums)):
        for j in range(i):
            if nums[j] < nums[i]:  # 
                dp[i] = max(dp[i], dp[j]+1)   # 迭代，取最长序列长度
    
    res = max(dp)
    return res

