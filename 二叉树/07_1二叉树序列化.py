# 297二叉树序列化与反序列化-2021年3月13日-前序遍历框架+递归法，此法还有较大优化空间

from BiTree import *

class Tree(BiTree):
    def __init__(self):
        self.res = []

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
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if root is None:
            self.res.append("#")
            return
        self.res.append(str(root.data))
        self.serialize(root.left)
        self.serialize(root.right)

        return ','.join(self.res)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        # 输入： "1,2,#,#,3,4,#,#,5,#,#"
        def des(data):
            if len(data) == 0:
                return
            d = data.pop(0)
            root = Node(d)
            if root.data == '#':
                return None 
            root.left = des(data)
            root.right = des(data)
            return root

        if data is None:
            return None

        data = data.split(",")
        root = des(data)
        return root



tree = Tree()
nums = [1,2,3,4,5,'#','#']
root = tree.construct(nums)
ans = tree.deserialize(tree.serialize(root))
tree.print_tree(ans)
# print(ans)