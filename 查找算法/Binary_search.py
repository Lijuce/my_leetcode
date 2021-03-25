# 704. 二分查找（基本）
def search(nums: list, target: int) -> int:
    left = 0
    right = len(nums) - 1
    while(left <= right):
        mid = left+ (right-left) // 2  # 计算 mid 时防⽌溢出
        if nums[mid] < target:
            left = mid + 1
        elif nums[mid] > target:
            right = mid -1 
        elif nums[mid] == target:
            return mid
    
    return -1

# 寻找左边界的二分查找
def LeftBoundSearch(nums: list, target: int) -> int:
    left = 0
    right = len(nums) - 1
    while(left <= right):
        mid = left+ (right-left) // 2
        if nums[mid] < target:
            left = mid + 1
        elif nums[mid] > target:
            right = mid - 1 
        elif nums[mid] == target:
            right = mid - 1  #  注意此处不同点
    if left >= len(nums) or nums[left] != target:  # 检查下标越界情况
        return -1

    return left

# 寻找右边界的二分查找
def RightBoundSearch(nums: list, target: int) -> int:
    left = 0
    right = len(nums) - 1
    while(left <= right):
        mid = left+ (right-left) // 2
        if nums[mid] < target:
            left = mid + 1
        elif nums[mid] > target:
            right = mid - 1 
        elif nums[mid] == target:
            left = mid + 1  #  注意此处不同点
    if left >= len(nums) or nums[right] != target:  # 检查下标越界情况
        return -1

    return right

nums = [1,2,2,2,3]
target = 2
print(RightBoundSearch(nums, target))
