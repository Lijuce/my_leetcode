# 1011. 在 D 天内送达包裹的能力

def shipWithinDays(weights, D: int) -> int:
    def isFinished(weights, cap, D):
        day = 1
        cur_cap = 0
        for w in weights:
            if w + cur_cap > cap:  # 测试每次装载货物后是否超过最大容量
                day += 1  # 
                if day > D:
                    return False
                cur_cap = w
            else:
                cur_cap += w
        return True

    left = max(weights)  # 以最大货物重量为最小装载量
    right = sum(weights) + 1  # 最大装载量即货物总量，一次性装完
    while left <= right:
        mid = left + (right - left) // 2
        if isFinished(weights, mid, D):
            right = mid - 1
        else:
            left = mid + 1
    return left

