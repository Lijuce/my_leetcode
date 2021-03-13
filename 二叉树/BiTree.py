class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None

class BiTree:
    def __init__(self):
        self.root = None  # 二叉树的根初始化

    def construct(self, datas: list, mode="BFS"):
        # 二叉树的构建
        self.root = Node(datas[0])  # 根节点
        if mode == 'BFS':
            # 层次遍历方式构建，如[1, 2, 3, 4, 5, 1, 2, '#', '#', '#', '#', '#', '#'], # 为空节点
            #       1
            #      / \
            #     2   3
            #    / \ 
            #   4   5
            stack = [self.root]
            for i in range(1, len(datas), 2):
                peek = stack.pop(0)

                if datas[i] != '#':
                    left = Node(datas[i])
                    peek.left = left
                    stack.append(peek.left)
                else:
                    left = Node(datas[i])
                    peek.left = left

                if i+1 < len(datas) and datas[i+1] != '#':
                    right = Node(datas[i+1])
                    peek.right = right
                    stack.append(peek.right)
                else:
                    right = Node(datas[i+1])
                    peek.right = right

        return self.root