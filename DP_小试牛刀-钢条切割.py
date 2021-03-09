# 金属切割-递归版本

p = {0:0, 1:1, 2:5, 3:8, 4:9, 5:10, 6:17, 7:17, 8:20, 9:24, 10:30}  # 价格表

# global q   # 收益
# def cut(p, length):
#     q = 0

#     if length == 0:
#         return 0
#     for i in range(1,length+1):
#         print(i)
#         q = max(q, p[i]+cut(p, length-i))  # 4 - 1/2/3/4
#     print("*")
#     return q

# r = cut(p, 5)
# print(r)

# 金属切割-备忘录版本

# p[0]+p[]
# 1 + 3   
# 1 + 1 + 2
# 1 + 1 + 1 +1
# 1 + 2 + 1

# 2 + 2
# 2 + 1 + 1

# 3 + 1

# 金属切割-动态规划
# def cut(list: p):
#     price = [0]*len(p)
#     for i in range(1,len(p)):
#         q = -1
#         for j in range(1,i+1):
#             q = max(q, p[j]+price[i-j])
#         price[i] = q
#     return price

# print(cut(p))

trie = {}
for word in ['apple']:  # 每个词汇的trie
    # print()
    t = trie
    print(id(t), id(trie))
    print("*"*10)
    for c in word:  # 相同首字母
        print(trie)
        if c not in t: 
            t[c] = {}  # t['a'] = {}  'a': {}
        t = t[c]  #
        print(id(t), id(trie))

    t[None] = None
