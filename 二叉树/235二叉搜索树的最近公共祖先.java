class Solution {
    /**
     * 235.二叉搜索树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == q || root ==p)
            return root;
        // 由于二叉搜索树的特性
        // 若root值大于right值，则说明p和q都位于左子树
        // 若root值小于left值，则说明p和q都位于右子树
        // 若root值 位于left和right值的中间，则说明p和q分别位于左右子树
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }
}