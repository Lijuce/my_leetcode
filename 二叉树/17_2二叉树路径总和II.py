# 2021年4月8日
# 113. 路径总和 II

def pathSum(root: TreeNode, targetSum: int) -> List[List[int]]:
    # 深度优先遍历-递归
    # 也称为-回溯法
    sum_val = 0
    res = []
    track = []
    def dfs(root, sum_val, track):
        if not root:  # base case
            return False

        sum_val += root.val
        track.append(root.val)
        if not root.left and not root.right:  # 确保最后是叶子节点
            if targetSum == sum_val:  # 当总和等于目标和时，保存走过的路径
                res.append(track.copy())

        dfs(root.left, sum_val, track)
        dfs(root.right, sum_val, track)
        track.pop()  # 撤回刚刚的选择（回溯法步骤之一）

    _ = dfs(root, sum_val, track)
    return res