/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * 437. 路径总和 III
     * 最简单直接的方法-深度优先遍历（复杂度较高，有很多重复路径）
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        // 从根开始进行遍历
        int result = dfs(root, targetSum);
        // 再以左右子树分别作为根，重复执行上一步骤
        int leftSize = pathSum(root.left, targetSum);
        int rightSize = pathSum(root.right, targetSum);

        return result + leftSize + rightSize;
    }

    public int dfs(TreeNode root, int sum) {
        if (root == null)
            return 0;
        sum -= root.val;

        int result = sum == 0? 1:0;
        return result + dfs(root.left, sum) + dfs(root.right, sum);
    }
}


