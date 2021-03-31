# 452. 用最少数量的箭引爆气球
# 和前一题几乎一样

def intervalSchedule(interv):
    interv.sort(key=lambda x: x[1])  # 按照第二列数进行递增排序
    count = 1
    x_end = interv[0][1]
    for inter in interv:
        start = inter[0]
        if start > x_end:  # 直接比较该区间的起始点与前一区间的终点
            count += 1
            x_end = inter[1]

    return count
    
def findMinArrowShots(points) -> int:
    length = len(points)
    if length < 1:
        return 0
    return self.intervalSchedule(points)
