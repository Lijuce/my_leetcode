# 213. 打家劫舍 II

def rob(self, nums: List[int]) -> int:

    length = len(nums)
    if length == 1:
        return nums[0]
    if length == 2:
        return max(nums[0], nums[1])
    
    def robRange(nums, start, end):  # 第一个和最后一个，两个选择。取多弃少，择优而动
        dp_i_1, dp_i_2 = 0, 0
        dp_max = 0
        for i in range(end, start-1, -1):
            dp_max = max(dp_i_1, dp_i_2+nums[i])
            dp_i_2 = dp_i_1
            dp_i_1 = dp_max            
        return dp_max

    return max(robRange(nums, 0, length-2), robRange(nums, 1, length-1))

    # 以下两段代码，合并成上面一段 robRange()
    # dp_i_1, dp_i_2 = 0, 0
    # nums_1 = nums[:-1]
    # dp_max_1 = 0
    # for i in range(length-2, -1, -1):
    #     dp_max_1 = max(dp_i_1, dp_i_2+nums_1[i])
    #     dp_i_2 = dp_i_1
    #     dp_i_1 = dp_max_1
    
    # nums_2 = nums[1:]
    # dp_i_1, dp_i_2 = 0, 0
    # dp_max_2 = 0
    # for i in range(length-2, -1, -1):
    #     dp_max_2 = max(dp_i_1, dp_i_2+nums_2[i])
    #     dp_i_2 = dp_i_1
    #     dp_i_1 = dp_max_2
    
    
    # return max(dp_max_1, dp_max_2)