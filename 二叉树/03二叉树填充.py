# 116题号-二叉树节点右侧指针填充

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

    def connectTwoNode(self, a, b):
        # 递归法连接
        if a is None or b is None:
            return

        a.next = b
        
        self.connectTwoNode(a.left, a.right)  # 相同父节点的两个子节点
        self.connectTwoNode(b.left, b.right)
        self.connectTwoNode(a.right, b.left)  # 跨越父节点的两个子节点

    def connect(self, root):
        if root is None:
            return root

        self.connectTwoNode(root.left, root.right)

        return root

tree = Tree()
nums = [1, 2, 3, 4, 5, '#', '#', '#', '#', '#', '#']
root = tree.construct(nums)
tree.connect(root)
tree.preorder(root)
