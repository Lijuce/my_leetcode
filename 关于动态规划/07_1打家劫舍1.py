# 198. 打家劫舍

def rob(nums) -> int:

    # # 自顶向下，带备忘录的动态规划
    # memo = {}  # 备忘录

    # def dp(nums, start):
    #     if start >= len(nums):
    #         return 0
    #     if start in memo:
    #         return memo[start]

    #     res = max(
    #         dp(nums, start+1),  # 此家不抢，去下家
    #         nums[start] + dp(nums, start+2)  # 此家抢，去到下下家
    #     )

    #     memo[start] = res
    #     return res
            
    # return dp(nums, 0)

    # 自底向上的动态规划
    length = len(nums)
    dp = [0 for i in range(length+2)]  # dp[i] 抢到第i家最多能获得的金钱为dp[i]
    # dp_i_1, dp_i_2 = 0, 0

    for i in range(length-1, -1, -1):
        dp[i] = max(dp[i+1], nums[i]+dp[i+2])  # dp[i]仅和最近两个dp有关，空间可优化  
        # dp_final = max(dp_i_1, nums[i] + dp_i_2)
        # dp_i_2 = dp_i_1
        # dp_i_1 = dp_final
    
    return dp[0]
    # return dp_final

print(rob([2,7,9,3,1]))


