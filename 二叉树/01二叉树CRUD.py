# 二叉树的增、删、查、改
from BiTree import *

class Tree(BiTree):
    def print_tree(self, root, mode='preorder'):
        if mode == 'preorder':
            print("前序遍历输出：", end='')
            self.preorder(root)
            print("")
        elif mode == 'inorder':
            print("中序遍历输出：", end='')
            self.inorder(root)
            print("")
        elif mode == 'postorder':
            print("后序遍历输出：", end='')
            self.postorder(root)        
            print("")
        elif mode == 'BFS':
            print("层次遍历输出：", end='')
            self.BFS(root)
            print("")
        else:
            raise ValueError("No the mode!")

    def preorder(self, root):
        # 前序遍历
        if root is None:
            return
        if root.data != '#':
            print(root.data, end=' ')
        self.preorder(root.left)
        self.preorder(root.right)
    
    def inorder(self, root):
        # 中序遍历
        if root is None:
            return
        self.inorder(root.left)
        if root.data != '#':
            print(root.data, end=' ')
        self.inorder(root.right)

    def postorder(self, root):
        # 后序遍历
        if not root:
            return
        if root.data != '#':
            print(root.data, end=' ')
        self.postorder(root.left)
        self.postorder(root.right)
        print(root.data, end=' ')

    def BFS(self, root):
        # 层次遍历
        if root is None:
            return

        stack = [root]
        while stack:
            peek = stack.pop(0)
            if peek is None:
                return
            right = peek.right
            left = peek.left
            print(peek.data, end=' ')

            stack.append(left)
            stack.append(right)

tree = Tree()
nums = [1, 2, 3, 4, 5, 6, 7, '#', '#', '#', '#', '#', '#', '#', '#']
root = tree.construct(nums)
tree.print_tree(root)
tree.print_tree(root, mode='inorder')
