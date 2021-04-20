# 875. 爱吃香蕉的珂珂

def minEatingSpeed(piles, h: int) -> int:
    def CanFinished(piles, speed, H):  # 判断是否能在H时间内，以speed的速度吃完所有香蕉
        temp = []
        time = 0
        # for p in piles:
        #     tmp = 1 if (p%speed)>0 else 0  # 一次性吃不完，第二小时接着吃
        #     time += ((p//speed)+tmp)  
        # return time <= H
        for p in piles:
            t = p//speed
            time += t
            if t > 0 and p%speed > 0:
                time+=1
        return time <= H

    left = 1  # 最小吃速至少为1
    right = max(piles)  # 以一堆香蕉中最大数量为右边界

    while left <= right:
        mid = left + (right-left) // 2
        if CanFinished(piles, mid, h):
            right = mid - 1
        else:
            left = mid + 1
    return left

piles = [3,6,7,11]
H = 8
print(minEatingSpeed(piles, H))
