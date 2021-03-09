class TreeNode(object):
    def __init__(self):
        self.left = -1  # 区间左端点
        self.right = -1  # 区间右端点
        self.sum_num = 0  # 区间和 (存储状态)

class Tree(object):
    def __init__(self, n, arr):
        self.n = n
        self.max_size = 4 * n
        self.tree = [TreeNode() for i in range(self.max_size)]  # 维护一个TreeNode数组
        self.arr = arr
    
    # index从1开始
    def _build(self, index, left, right):
        self.tree[index].left = left
        self.tree[index].right = right
        if left == right:
            self.tree[index].sum_num = self.arr[left - 1]
        else:
            mid = (left + right) // 2
            self._build(index * 2, left, mid)
            self._build(index * 2 + 1, mid + 1, right)
            # self.pushup_sum(index)
            self.tree[index].sum_num = self.tree[index * 2].sum_num + self.tree[index * 2 + 1].sum_num  # 求和（即线段树里的状态合并）

    # 构建线段树
    def build(self):
        self._build(1, 1, self.n)

# n = 6  # 1 5 4 2 3
# arr = [1, 5, 4, 2, 3, 1]
# tree = Tree(n, arr)
# tree.build()

# def build(index, left, right, arr) 
#     """
#     index：指引用的索引
#     left：左端点索引
#     right：右端点索引
#     """
#     tree[index].left = left
#     tree[index].right = right
#     if left == right:
#         tree[index].sum_num = arr[left-1]
#     else:
#         mid = (left + right) // 2
#         build(index*2, left, mid, arr)
#         build(index*2 + 1, )


# def build_tree(n, arr):
#     """
#     n: 区间长度
#     arr：区间具体内容
#     index：指引用的索引
#     left：左端点索引
#     right：右端点索引
#     """
#     max_size = 4 * n
#     tree = [TreeNode() for i in range(max_size)]
    
#     build(1, 1, n, arr)
