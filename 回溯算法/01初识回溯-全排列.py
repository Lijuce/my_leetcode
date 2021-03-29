# 46. 全排列

def permute(nums):
    res = []
    def backtrack(nums, track):

        # 触发结束条件
        if len(track) == len(nums):
            res.append(track.copy())  # 或者 track[:]
        
        for i in range(len(nums)):
            if nums[i] in track:  # 已做过相同选择，跳过
                continue
            
            track.append(nums[i])  # 将选择加入路径

            # 进入下一层决策树
            backtrack(nums, track)

            track.pop()  # 回撤选择
            
    track = []
    backtrack(nums, track)
    return res

print(permute([1,2,3]))
