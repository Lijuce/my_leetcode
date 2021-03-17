# 53 最大子序和

def maxSubArray(self, nums):

    # 动态规划法解决
    length = len(nums)
    if length <= 0:
        return 0
    if length <2:
        return nums[0]
    # dp = [0] * length
    # dp[0] = nums[0]
    for i in range(1, length):
        # dp[i] = max(nums[i], dp[i-1]+nums[i])  # 空间复杂度 O(n)
        nums[i] = nums[i] + max(nums[i-1], 0)
    return max(nums)



# 有更优解法，分治法。
# To do
