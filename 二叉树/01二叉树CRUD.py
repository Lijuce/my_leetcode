# 二叉树的增、删、查、改

class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None

class BiTree(object):
    def __init__(self):
        self.root = None  # 二叉树的根初始化

    def construct(self, datas: list):
        # 二叉树的构建
        self.root = Node(datas[0])  # 根节点
        stack = [self.root]
        for i in range(1, len(datas), 2):
            if datas[i] != None:
                left = Node(datas[i])
            else:
                left = None

            if i+1 < len(datas) and datas[i+1] != None:
                right = Node(datas[i+1])
            else:
                right = None
            
            peek = stack.pop()
            peek.left = left
            peek.right = right
            stack.append(peek.right)

        return self.root

    def print_tree(self, root):
        if root == None:
            return []
        result = []
        queue = []
        queue.append(root)
        while len(queue) != 0:
            peek = queue.pop()
            if peek == None:
                if len(queue) != 0:
                    result.append(None)
            else:
                result.append(peek.data)

                if peek.right != None or peek.left != None:
                    queue.append(peek.right)
                    queue.append(peek.left)
        print(result)
        return result

tree = BiTree()
nums = [1, 3, 2, 5]
root = tree.construct(nums)
tree.print_tree(root) 


