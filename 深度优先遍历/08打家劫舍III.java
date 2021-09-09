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
     * 337. 打家劫舍 III
     * dfs+动态规划思想，结合树形DP(二叉树的后续遍历框架)
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    // 设立长度2的数组，分别存放 不抢(0) 和 抢(1) 的结果。
    public int[] dfs(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // 抢该节点，意味着不能再抢左右子节点
        int robThis = root.val + left[0] + right[0];
        // 不该节点时，进行判断，看怎么抢最大化
        int noRobThis = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{noRobThis, robThis};
    }


}