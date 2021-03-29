# 77. 组合

def combine(n: int, k: int):
    
    # nums = [i for i in range(1, n+1)]
    res = []
    track = []
    def drawback(nums, track, start):
        if len(track) == k :
            res.append(track.copy())
            return
        for i in range(start, nums+1):
            # if len(track) > k:
            #     continue
            track.append(i)

            drawback(nums, track, i+1)

            track.pop()
    drawback(n, track, 1)
    return res

print(combine(4, 2))