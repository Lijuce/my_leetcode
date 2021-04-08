# 2021年4月8日
# 力扣热门100题之一
# 101. 对称二叉树

def isSymmetric(root) -> bool:
    # 深度遍历优先-递归
    t1, t2 = root, root
    # def dfs(root1, root2):
    #     if not root1 and not root2:  # 左右都为空，此节点对称
    #         return True
    #     if not root1 or not root2:   # 左右仅一节点为空，肯定不对称
    #         return False
    
    #     # 当左右节点都不为空，判断值是否相等
    #     # 并继续分别判断两个节点的左、右子节点
    #     return root1.val == root2.val and dfs(root1.left, root2.right) and dfs(root1.right, root2.left)

    # flag = dfs(t1, t2)

    # return flag

    # 广度遍历优先-迭代法（利用队列，即层次遍历法）
    stack = [t1, t2]
    while stack:
        r_Node = stack.pop()
        l_Node = stack.pop()

        if not r_Node and not l_Node:
            continue
        if not r_Node or not l_Node or r_Node.val != l_Node.val:
            return False

        stack.append(r_Node.left)
        stack.append(l_Node.right)

        stack.append(r_Node.right)
        stack.append(l_Node.left)
    return True