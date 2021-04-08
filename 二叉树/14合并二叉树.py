# 2021年4月7日
# 力扣热门100题之一
# 617. 合并二叉树

def mergeTrees(self, root1: TreeNode, root2: TreeNode) -> TreeNode:
    # 前序遍历框架+递归
    # def dfs(r1, r2):
    #     if not r1 or not r2:  # 只要任意子树为空，即退回
    #         return

    #     if r1.left and r2.left:
    #         r1.left.val += r2.left.val
    #     elif not r1.left and r2.left:
    #         r1.left = TreeNode(r2.left.val)
        
    #     if r1.right and r2.right:
    #         r1.right.val += r2.right.val
    #     elif not r1.right and r2.right:
    #         r1.right = TreeNode(r2.right.val)

    #     dfs(r1.left, r2.left)  # 先合并左边子树
    #     dfs(r1.right, r2.right)  # 再合并右边子树

    # if root1 and root2:
    #     root1.val += root2.val
    # if not root1:
    #     return root2
    # if not root2:
    #     return root1
        
    # dfs(root1, root2)
    # return root1
    
    # 代码精简优化：（深度优先遍历）
    def dfs(r1, r2):
        if not r1 or not r2:
            return r1 if r1 else r2
        
        r1.val += r2.val
        r1.left = dfs(r1.left, r2.left)
        r1.right = dfs(r1.right, r2.right)

        return r1
    return dfs(root1, root2)

    # 广度优先遍历
    if not (t1 and t2):
        return t2 if not t1 else t1
    queue = [(t1,t2)]
    while queue:
        r1,r2 = queue.pop(0)
        r1.val += r2.val
        # 如果r1和r2的左子树都不为空，就放到队列中
        # 如果r1的左子树为空，就把r2的左子树挂到r1的左子树上
        if r1.left and r2.left:
            queue.append((r1.left,r2.left))
        elif not r1.left:
            r1.left = r2.left
        # 对于右子树也是一样的
        if r1.right and r2.right:
            queue.append((r1.right,r2.right))
        elif not r1.right:
            r1.right = r2.right
    return t1
