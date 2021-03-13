# 题号114-二叉树展开为链表

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

    def flatten(self, root):
        """
        Do not return anything, modify root in-place instead.
        """
        if root is None:
            return

        # 后续遍历+递归
        self.flatten(root.left)
        self.flatten(root.right)

        tmp_left = root.left
        tmp_right = root.right

        root.right = root.left
        root.left = None

        p = root
        while p.right is not None:
            p = p.right
        p.right = tmp_right

tree = Tree()
nums = [1, 2, 3, 4, 5, '#', '#', '#', '#', '#', '#']
root = tree.construct(nums)

tree.flatten(root)
tree.preorder(root)
