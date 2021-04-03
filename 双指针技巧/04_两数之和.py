# 167. 两数之和 II - 输入有序数组

def twoSum(numbers, target: int):
    left = 0
    right = len(numbers) - 1
    sum_val = numbers[left] + numbers[right]

    while left <= right:
        sum_val = numbers[left] + numbers[right]
        if sum_val == target:
            return [left+1, right+1]
        elif sum_val > target:
            right -= 1  # 表明总和大于目标，右边的值需要小点
        elif sum_val < target:
            left += 1  # 表明总和小于目标，左边的值需要大点
    return [-1, -1]  # 答案不存在
