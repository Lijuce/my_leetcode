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
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> track = new ArrayList<>();

    /**
     * 113. 路径总和 II
     * DFS结合回溯思想
     *
     * @param root
     * @param target
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, 0, target);
        return res;
    }

    private void dfs(TreeNode root, int sum, int target) {
        if (root == null)
            return ;

        sum += root.val;
        track.add(root.val);
        // 依题意，需遍历至叶子节点才算是有效组合
        if (root.left == null && root.right == null)
            if (sum == target)
                res.add(new ArrayList(track));

        dfs(root.left, sum, target);
        dfs(root.right, sum, target);

        // 回撤选择
        track.remove(track.size() - 1);
    }
}