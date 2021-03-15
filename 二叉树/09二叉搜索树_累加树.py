# 538-二叉搜索树转化累加树，2021年3月14日

from BiTree import *

class Tree(BiTree):
    def __init__(self):
        self.nums = 0
        
    def traverse(self, root):
        # 利用 BST 的中序遍历特性
        if root is None:
            return

        self.traverse(root.right)
        self.nums += root.val
        root.val = self.nums
        self.traverse(root.left)

    def convertBST(self, root: Node):
        # 中序遍历框架+迭代法
        self.traverse(root)

        return root

