/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 剑指 Offer 28. 对称的二叉树
     * 二叉树的深度遍历优先
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return dfs(root.left, root.right);
    }
    public boolean dfs(TreeNode root1, TreeNode root2) {
        // 递归终止条件1：两个树同时为null，恰好都相同
        if (root1 == null && root2 == null)
            return true;
        // 递归终止条件2：两个树中，仅有一个为null，比不对称
        if (root1 == null || root2 == null)
            return false;

        return dfs(root1.left, root2.right) && dfs(root1.right, root2.left) && root1.val==root2.val;
    }
}