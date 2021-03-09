import time
# 斐波那契数列解法一：简单递归

# def Fibonacci(n):
#     if n <= 0:
#         return 0
#     if n == 1:
#         return 1
#     return fib(n-1)+fib(n-2)

# start = time.time()
# r = fib(30)
# end = time.time()
# print("Time:", end-start)
# print(r)

# 斐波那契数列解法二：  自顶向下的备忘录

# fib_memory = {}
# def Fibonacci(n):
#     if n <= 0:
#         return 0
#     # fib_memory
#     for i in range(n+1):
#         fib_memory[i] = -1
#     return fib(n, fib_memory)

# def fib(n, memo):
#     if memo[n] != -1:
#         return memo[n]
#     if n <= 2:
#         memo[n] = 1
#     else:
#         memo[n] = fib(n-1, memo) + fib(n-2, memo)
#     return memo[n]
    
# print(fib_memory)

# 斐波那契数列解法三：  简单动态规划

fib_memory = {}
def Fibonacci(n):
    if n <= 0:
        return n
    # fib_memory[0] = 0
    # fib_memory[1] = 1
    fib_memory_i_2 = 0
    fib_memory_i_1 = 1
    fib_memory_i = 1
    for i in range(2, n+1):
        # fib_memory[i] = fib_memory[i-1] + fib_memory[i-2]
        # 空间复杂度进一步优化
        fib_memory_i = fib_memory_i_2 + fib_memory_i_1
        fib_memory_i_2 = fib_memory_i_1
        fib_memory_i_1 = fib_memory_i
    return fib_memory_i

start = time.time()
r = Fibonacci(10000)
end = time.time()
print("Time:", end-start)
# print(r)

