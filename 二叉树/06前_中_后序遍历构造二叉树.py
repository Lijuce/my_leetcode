# 题号105-前序与中序遍历序列构造二叉树
# 题号106-中序与后序遍历序列构造二叉树

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

    def buildTree_prein(self, preorder: list, inorder: list):
        # 前中序遍历构建
        def build(preorder, preStart, preEnd, 
                  inorder, inStart, inEnd):
            if preStart > preEnd:  # base case
                return None

            ### 用前序遍历框架，结合递归法
            root_val = preorder[preStart]  # 根节点值
            root = Node(root_val)  # 根节点

            # 确定根节点的索引
            root_index = inorder.index(root_val)

            left_size = root_index-inStart

            root.left = build(preorder, preStart+1, preStart+left_size, 
                              inorder, inStart, root_index-1)
            root.right = build(preorder, preStart+left_size+1, preEnd,
                               inorder, root_index+1, inEnd)
            return root

        root = build(preorder, 0, len(preorder)-1,
                     inorder, 0, len(inorder)-1)
        return root    
    
    def buildTree_inpost(self, postorder: list, inorder: list):
        # 中后序遍历构建
        def build(postorder, postStart, postEnd, 
                  inorder, inStart, inEnd):
            if inStart > inEnd:  # base case
                return None

            # 用前序遍历框架，结合递归法
            root_val = postorder[postEnd]  # 根节点值
            root = Node(root_val)  # 根节点

            # 确定中序 根节点的索引
            root_index = inorder.index(root_val)

            left_size = root_index-inStart

            root.left = build(postorder, postStart, postStart+left_size-1, 
                                inorder, inStart, root_index-1)
            root.right = build(postorder, postStart+left_size, postEnd-1,
                                inorder, root_index+1, inEnd)

        root = build(postorder, 0, len(postorder)-1,
                     inorder, 0, len(inorder)-1)
        return root

