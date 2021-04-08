# 652-寻找重复的子树，2021年3月14日

from BiTree import *

class Tree(BiTree):
    def __init__(self):
        self.res_root = []  # 记录重复子树的根
        self.res = dict()  # 记录重复子树的出现次数

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

        def serialize(self, root):
            # 二叉树后序遍历序列化
            # 后续遍历框架+递归法
            if root is None:
                return "#"
                
            left = self.serialize(root.left)
            right = self.serialize(root.right)

            subtree = left + "," + right + "," + str(root.data)
            if subtree in self.res:
                self.res[subtree] += 1
            else:
                self.res[subtree] = 0

            if self.res[subtree] == 1:  # 当此字符串树等于1，即表明重复过
                self.res_root.append(root)  # 避免重复添加 重复子树的根

            return subtree
        
        def findDuplicateSubtrees(self, root: Node):
            # 后续遍历框架+递归法
            # 使用到二叉树序列化
            r = self.serialize(root)

            return self.res_root

