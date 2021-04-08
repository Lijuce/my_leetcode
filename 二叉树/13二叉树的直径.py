# 力扣热门100题之一
# 543. 二叉树的直径

def diameterOfBinaryTree(self, root: TreeNode) -> int:
    # 深度遍历有限 (后续遍历框架)
    self.ans = 0
    def dfs(root):
        if root is None:
            return 0
        hl = dfs(root.left)
        hr = dfs(root.right)
        self.ans = max(self.ans, hl+hr+1)  # 计算每个节点为根节点时的树的最大节点数
        return max(hl, hr)+1

    dfs(root)
    return self.ans-1