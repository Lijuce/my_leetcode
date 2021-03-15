# 230-寻找第K小的元素，2021年3月14日

from BiTree import *

class Tree(BiTree):
    def __init__(self):
        self.res = 0
        self.rank = 0

    def traverse(self, root, k):  # 充分利用中序遍历结果是升序的特性
        if root is None or self.rank>k:  # 适当剪枝，避免每次都遍历整颗树
            return 
        self.traverse(root.left, k)
        self.rank += 1  # 当前元素排名
        
        if self.rank == k:
            self.res = root.val
            return 

        self.traverse(root.right, k)

    def kthSmallest(self, root: Node, k: int):
        self.traverse(root, k)

        return self.res

