# 416 子集切割问题
# 可转化为背包问题来解决

nums = [14,9,8,4,3,2]

length = len(nums)  
sum_value = sum(nums)

target_value = sum_value // 2
if sum_value % 2 != 0:  # 和为奇数时一定无法切割
    print(False)
    exit()

# dp = [[False for i in range(target_value+1)] for j in range(length+1)]  # 定义dp
# for i in range(length+1):
#     dp[i][0] = True  # base case

# for i in range(1, length+1):  
#     for j in range(1, target_value+1):
#         if j-nums[i-1] < 0:  # 此时背包容量不足，不能装入第i个物品
#             dp[i][j] = dp[i-1][j]
#         else:
#             dp[i][j] = dp[i-1][j] or dp[i-1][j-nums[i-1]]  # 进行选择，装入或不装入背包
# print(dp[length][target_value])


### 优化版
# 将dp二维数组降为一位数组来存储这些状态 (空间复杂度优化)
dp = [False for i in range(target_value+1)]
dp[0] = True  # base case

for i in range(0, length):
    for j in range(target_value, -1, -1):
        if j-nums[i] >= 0:
            dp[j] = dp[j] or dp[j-nums[i]]
print(dp[target_value])

        # for i in range(0, length):
        #     for j in range(mid_value, -1, -1):
        #         if j-nums[i] >= 0:
        #             dp[j] = dp[j] or dp[j-nums[i]]

        # return dp[mid_value]


# # 枚举法，暴力解决
# target, res = divmod(sum(nums), 2)
# if res: return False

# sums = {0}  # 存所有子集和
# for num in nums:
#     tmp = {s + num for s in sums}  # 遍历已有的子集和，加上num就可以得到更多的子集和
#     if target in tmp: return True  # 如果中途达成目标了，就可以返回True了
#     sums |= tmp  # 加入这一轮得到的子集和

# return False