def subsets(nums):
    length = len(nums)
    res = []
    def drawback(nums, track, start):
        # if track not in res:
        res.append(track.copy())

        for i in range(start, length):  # i 从 start开始递增？
                                        # 为了避免重复添加之前有过的路径，例如
            if nums[i] in track:
                continue
            track.append(nums[i])

            drawback(nums, track, i+1)  # 注意i+1

            track.pop()  # 默认从最后一个弹出
    drawback(nums, [], 0)
    return res

print(subsets([1,2,3]))