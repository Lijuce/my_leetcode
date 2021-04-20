# 剑指 Offer 53 - II. 0～n-1中缺失的数字

def missingNumber(self, nums) -> int:
    length = len(nums)
    # if length == 1 and nums[0]==0:
    #     return 1

    # 法一：暴力搜索
    # for i in range(0, length+1):
    #     if i not in nums:
    #         return i

    # 法二：二分查找
    # def isMissing(nums, left, right):
    #     if (right - left + 1) == nums[right]:
    #         return False
    #     else:
    #         return True

    # left = 0
    # right = length - 1
    # while left <= right:
    #     mid = left + (right-left) // 2
    #     if nums[mid] == mid:
    #         left = mid + 1  # [0,1,2,3]这类，需要+1
    #     else:
    #         right = mid - 1  # [0,1,3]这类，说明缺的就刚好在[mid, righut]区间内
    # return left

    # 法三：位运算-异或
    # xor = 0
    # for i in range(0, length):
    #     xo = (i+1) ^ nums[i]  # 注意异或是按位进行，即二进制形式
    #     xor = xo ^ xor
    # return xor
        # if xor == 1:
        #     return i               
    # return nums[length-1]+1