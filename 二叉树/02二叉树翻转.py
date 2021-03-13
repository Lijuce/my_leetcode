# 226题号-二叉树翻转

from BiTree import *

class Tree(BiTree):
    def print_tree(self, root, mode='preorder'):
        if mode == 'preorder':
            print("前序遍历输出：", end='')
            self.preorder(root)
            print("")

    def preorder(self, root):
        # 前序遍历
        if root is None:
            return
        if root.data != '#':
            print(root.data, end=' ')
        self.preorder(root.left)
        self.preorder(root.right)

    def inverseTree(self, root):
        if root is None:  # base case
            return None
        tmp = root.left
        root.left = root.right
        root.right = tmp
        self.inverseTree(root.left)
        self.inverseTree(root.right)

        return root

tree = Tree()
nums = [1, 2, 3, 4, 5, '#', '#', '#', '#', '#', '#']
root = tree.construct(nums)
root = tree.inverseTree(root)
tree.preorder(root)