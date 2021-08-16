def jump(nums) -> int:
    final_position = len(nums)
    end = 0
    farthest = 0
    jumps = 0
    for i in range(final_position-1):           
        farthest = max(nums[i]+i, farthest)  # 保留可达最远距离
        if end == i:  # 到达局部最远处，继续做比较
            jumps += 1
            end = farthest
    
    return jumps


