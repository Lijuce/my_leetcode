def missingNumber(nums) -> int:
    length = len(nums)
    if length == 1 and nums[0]==0:
        return 1

    # 暴力搜索
    # for i in range(0, length+1):
    #     if i not in nums:
    #         return i

    # 二分查找
    def isMissing(nums, left, right):
        if (right - left + 1) == nums[right]:
            return False
        else:
            return True

    left = 0
    right = length - 1
    while left <= right:
        mid = left + (right-left) // 2
        if nums[mid] == mid:
            left = mid + 1  # [0,1,2,3]这类，需要+1
        else:
            right = mid - 1  # [0,1,3]这类，说明缺的就刚好在[mid, righut]区间内
    return left

    #     if isMissing(nums, left, right):
    #         left = mid + 1
    #     else:
    #         right = mid - 1
    # return right
