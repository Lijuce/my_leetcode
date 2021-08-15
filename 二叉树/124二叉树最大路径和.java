class Solution {
    int maxValue = Integer.MIN_VALUE;

    /**
     * 热门100题
     * 后续遍历DFS
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return maxValue;
    }
    public int dfs(TreeNode root){
        if (root == null)
            return 0;
        // 计算左分支最大值，若为负则不选
        int leftMax = Math.max(0, dfs(root.left));
        // 计算右分支最大值，若为负则不选
        int rightMax = Math.max(0, dfs(root.right));
        // 由于路径最大的一种可能为left-root-right，而不会再想root的父节点延伸
        int rootSum = root.val + leftMax + rightMax;
        // 更新最大值，即使全是负数节点的情况，也会进行更新
        
        // 向root的父节点返回经过root的单边分支最大路径和
        maxValue = Math.max(maxValue, rootSum);
        return root.val + Math.max(leftMax, rightMax);
    }
}