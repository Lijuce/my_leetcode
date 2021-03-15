# 2021年3月15日 二叉搜索树增删查改（递归）
# 450-删除二叉搜索树中的节点
# 701-二叉搜索树中的插入操作
# 700-二叉搜索树中的搜索
# 98-验证二叉搜索树

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

    def deleteNode(self, root: Node, key: int):
        # 删除二叉搜索树中的节点
        if root is None:
            return None

        if root.data == key:
            if root.left is None:
                return root.right
            if root.right is None:  
                return root.left
            min_node = self.getMin(root.right)  # 寻找右子树中最小的节点代替自己
            root.data = min_node.data
            root.right = self.deleteNode(root.right, min_node.data)
        
        elif root.data < key:
            root.right = self.deleteNode(root.right, key)
        elif root.data > key:
            root.left = self.deleteNode(root.left, key)
        
        return root

    def getMin(self, root):
        while root.left is not None:
            root = root.left
        return root

    def addNode(self, root, key):
        # 二叉搜索树中插入新节点
        if root is None:
            return Node(key)

        if root.data < key:
            root.right = self.addNode(root.right, key)
        elif root.data > key:
            root.left = self.addNode(root.left, key)
        
        return root

        
    def searchBST(self, root: Node, key: int):
        # 二叉搜索树中搜索指定数
        if root is None:
            return None
            
        if root.data == key:
            return root
        elif root.data < key:
            root = self.searchBST(root.right, key)
        elif root.data > key:
            root = self.searchBST(root.left, key)
        
        return root

    def isValidBST(self, root: Node) -> bool:
        def isBST(root, min_node, max_node):  
            if root is None:
                return True

            val = root.data
            if min_node is not None and min_node.data >= val:
                return False
            if max_node is not None and max_node.data <= val:
                return False

            return (isBST(root.left, min_node, root) and isBST(root.right, root, max_node))  # root.val对于左子树是最大值，对于右子树是最小值

        return isBST(root, None, None)

tree = Tree()
nums = [4, 2, 7, 1, 3, '#', '#', '#', '#', '#', '#']
root = tree.construct(nums)
# root = tree.deleteNode(root, 3)
# root = tree.addNode(root, 0)
# root = tree.searchBST(root, 2)

# tree.print_tree(root)

print(tree.isValidBST(root))