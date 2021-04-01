# 216. 组合总和 III

def combinationSum3(k: int, n: int):
    
    res = []
    track = []



    def backtrack(track, k, n, start):
        sum_track = sum(track)
        if len(track) == k and sum_track == n:  
            res.append(track.copy())
        elif sum_track > n:  # 还未加到K个数，总和已超过n，此时无需再往后尝试。因此，此处做剪枝
            return

        for i in range(start, 10):
            if i in track:
                continue

            track.append(i)

            backtrack(track, k, n, i+1)  # i+1 避免重复添加

            track.pop(-1)

    backtrack([], k, n, 1)
    return res



