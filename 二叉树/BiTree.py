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
        print("层次遍历方式构建二叉树:{} ".format(datas[0]), end='')
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
                data = datas[i]
                if data != '#':
                    left = Node(data)
                    peek.left = left
                    stack.append(peek.left)
                else:
                    left = Node(data)
                    peek.left = None
                print(data, end=' ')
                
                if i+1 < len(datas):
                    data = datas[i+1]
                    if data != '#':
                        right = Node(data)
                        peek.right = right
                        stack.append(peek.right)
                    else:
                        right = Node(data)
                        peek.right = None
                    print(data, end=' ')

        print('')
        return self.root