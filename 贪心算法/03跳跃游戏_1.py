# 55. 跳跃游戏

def canJump(nums) -> bool:
    # 贪心算法
    # final_position = len(nums)
    # farthest = 0

    # for i in range(final_position-1):
    #     farthest = max(farthest, i+nums[i])
    #     if farthest <= i:  # 表明原地踏步，永远到达不了终点
    #         return False
    
    # return farthest >= final_position-1

    # 优化    
    final_position = len(nums)
    max_i = 0       #初始化当前能到达最远的位置
    for i, jump in enumerate(nums):   #i为当前位置，jump是当前位置的跳数
        if max_i>=i and i+jump>max_i:  #如果当前位置能到达，并且当前位置+跳数>最远位置  
            max_i = i+jump  #更新最远能到达位置
    return max_i>=i
