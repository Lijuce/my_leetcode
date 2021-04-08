# 2021年4月8日
# 112. 路径总和

def hasPathSum(root: TreeNode, targetSum: int) -> bool:
    # 深度优先遍历-递归
    # res = 0
    # def dfs(root, res):
    #     if not root:  # base case
    #         return False
    #     res += root.val
    #     if not root.left and not root.right:  # 确保最后是叶子节点
    #         return targetSum == res 

    #     return dfs(root.left, res) or dfs(root.right, res)

    # return dfs(root, res)

    # 代码简洁优化
    if not root:
        return False
    if not root.left and not root.right:
        return targetSum == root.val
    return self.hasPathSum(root.left, targetSum - root.val) or self.hasPathSum(root.right, targetSum - root.val)