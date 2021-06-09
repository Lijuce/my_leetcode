class Solution {
    /**
     * 236. 二叉树的最近公共祖先
     * 后序遍历递归
     * 需多理解
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        // 若根节点是q或p，从此开始自底向顶回溯
        if (root == q || root ==p)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 同时不为空，q和p分别位于两侧
        if (left != null && right != null)
            return root;
        // 同时为空，返回null
        if (left == null && right == null)
            return null;
        // 有一个为空，分两种情况(假设left为空，right不为空，p和q都不在root的左子树中，直接返回right)
        // 1. p、q有一个在右子树中，需从right开始自底向顶回溯
        // 2. p、q两个都在右子树中，此事right就是最近公共祖先节点
        // 综上两种，无论怎样都是返回right
        if (left == null)
            return right;
        else
            return left;
    }
}