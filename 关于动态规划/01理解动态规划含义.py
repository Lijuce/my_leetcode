# 509 斐波那契数列
# 322 零钱兑换

def Fibonacci(n):
    # 斐波那契数列解法一：简单递归
    ## 时间复杂度：指数型 O(2^N), 因为其递归子问题数即二叉树的节点数
    # if n==0:
    #     return 0
    # if n==1 or n==2:
    #     return 1
    # return Fibonacci(n-1) + Fibonacci(n-2)

    # 解法二：  自顶向下的备忘录
    ## 时间复杂度：O(N) 
    # def fib(n, memo):
    #     if n==1 or n==2:  # base case
    #         return 1
    #     if memo[n] != -1:
    #         return memo[n]
    #     memo[n] = fib(n-1, memo) + fib(n-2, memo)

    # memo = {}  # 备忘录
    # if n<=0:
    #     return 0
    # for i in range(n+1):  # 备忘录全初始化为 -1
    #     fib_memory[i] = -1
    # return  fib(n-1, memo)

    # 解法三：  简单动态规划(自底向上)
    # 最优解: 时间复杂度不变，但其空间复杂度降为 O(1)
    if n==0:
        return 0
    if n==1 or n==2:
        return 1
    memo_i_1 = 1
    memo_i_2 = 1
    sum_memo = 0
    for i in range(2, n+1):  # 从2开始进行计算
        sum_memo = memo_i_1 + memo_i_2
        memo_i_2 = memo_i_1
        memo_i_1 = sum_memo
    return memo_i_1


def coinChange(self, coins: List[int], amount: int) -> int:
    # # 先定义dp(n),给定金额n，返回最少需要硬币树dp(n)
    # memo = {}# 备忘录

    # def dp(n):
    #     if n in memo:   # 查询备忘录
    #         return memo[n] 
    #     if n == 0:  # base case
    #         return 0
    #     if n < 0:  
    #         return -1
    #     res = float('INF')
    #     for coin in coins:
    #         counts = dp(n-coin)
    #         if counts == -1:
    #             continue
    #         res = min(res, counts+1)  # 选择需要硬币最少的那个结果
        
    #     memo[n] = res if res != float('INF') else -1
    #     return memo[n]
        
    # return dp(amount)
    
    dp = {}  
    dp = [amount+1] * (amount+1)
    # base case 
    dp[0] = 0
    for i in range(amount+1):  # 自底向上，每一个金额都去凑一遍硬币数
        for c in coins:
            if i-c < 0:
                continue
            dp[i] = min(dp[i], 1+dp[i-c])
    
    if dp[amount] == amount+1:
        return -1
    return dp[amount]

