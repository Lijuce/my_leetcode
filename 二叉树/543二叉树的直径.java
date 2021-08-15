class Solution {
    /**
     * 力扣热门100题之一
     * 543. 二叉树的直径
     * 可以转化为求每个节点的左右节点的最大深度之和的最大值
     * 思想：深度遍历优先 + 后续遍历框架
     */
    int totalSize = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return totalSize-1;  // 路径长度即边的个数 = 路径节点数-1
    }

    public int dfs(TreeNode root){
        if (root == null)
            return 0;
        int leftSize = dfs(root.left);
        int rightSize = dfs(root.right);
        totalSize = Math.max(leftSize+rightSize+1, totalSize);
        return Math.max(leftSize, rightSize) + 1;
    }
}