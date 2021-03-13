# 题号654-最大二叉树

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

    def constructMaximumBinaryTree(self, nums: list):
        # 递归构造最大二叉树
        if len(nums) == 0:  # base case
            return None
        max_val = max(nums)  # 获取最大值
        index = nums.index(max_val)  # 最大值对应索引
        
        root = Node(max_val)

        left_num = nums[:index]
        right_num = nums[index+1:]

        root.left = self.constructMaximumBinaryTree(left_num)
        root.right = self.constructMaximumBinaryTree(right_num)

        return root

tree = Tree()
nums = [3,2,1,6,0,5]
root = tree.constructMaximumBinaryTree(nums)
tree.preorder(root)