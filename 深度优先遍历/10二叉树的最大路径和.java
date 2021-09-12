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
    int resMax = Integer.MIN_VALUE;

    /**
     * 124. 二叉树中的最大路径和
     * DFS + 后续遍历框架
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return resMax;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        // 先计算左分支最大和
        int leftVal = dfs(root.left);
        int leftMax = Math.max(0, leftVal);
        // 再计算右分支最大和
        int rightVal = dfs(root.right);
        int rightMax = Math.max(0, rightVal);
        // 加上根节点的最大和
        int rootSum = root.val + leftMax + rightMax;

        // 更新最大值，即使全是负数节点的情况，也会进行更新
        // 向root的父节点返回经过root的单边分支最大路径和
        resMax = Math.max(resMax, rootSum);
        return Math.max(leftMax, rightMax) + root.val;
    }
}