# 2021年3月16日 
# 236-二叉树的最近公共祖先-难度较大，较不易理解

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

    def lowestCommonAncestor(self, root: 'Node', p: 'Node', q: 'Node'):
        # base case
        if root is  None:  
            return None
        if root == p or root == q:  
            return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left is None and right is None:  # 都不属于root根的树中
            return None

        if left is not None and right is not None:  
            return root
        
        return left if left else right  # 任意一节点处于root根节点的树中

tree = Tree()
nums = [4, 2, 7, 1, 3, '#', '#', '#', '#', '#', '#']
root = tree.construct(nums)
root = tree.lowestCommonAncestor(root, root.left.left, root.left)
tree.print_tree(root)

    