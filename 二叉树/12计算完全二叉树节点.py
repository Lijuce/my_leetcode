# 2021年3月16日 
# 222-完全二叉树的节点个数

from BiTree import *

class Tree(BiTree):

    def countNodes(self, root: Node) -> int:
        # # 法一：普通二叉树节点计算
        # if root is None:
        #     return 0

        # return 1 + self.countNodes(root.left) + self.countNodes(root.right) 

        # 法二：综合利用完全二叉树和满二叉树性质进行节点数计算
        right = root
        left = root
        hl, hr = 0, 0  # 左右子树高度计算

        while right is not None:
            right = right.right
            hr += 1
        while left is not None:
            left = left.left
            hl += 1
        if hl == hr:
            return pow(2, hr) - 1
        else:
            return 1 + self.countNodes(root.left) + self.countNodes(root.right)

tree = Tree()
nums = [4, 2, 7, 1, 3, '#', '#', '#', '#', '#', '#']
root = tree.construct(nums)
print(tree.countNodes(root))

