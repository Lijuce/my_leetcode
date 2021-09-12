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
    List<String> res = new ArrayList<>();

    /**
     * 257. 二叉树的所有路径
     * 经典的回溯思想+前序遍历
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return res;
        List<Integer> paths = new ArrayList<>();
        dfs(root, paths);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> paths) {
        paths.add(root.val);
        // 叶子节点
        if (root.left == null && root.right == null) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < paths.size()-1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size()-1));
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
            dfs(root.left, paths);
            // 回撤选择
            paths.remove(paths.size()-1);
        }
        if (root.right != null) {
            dfs(root.right, paths);
            // 回撤选择
            paths.remove(paths.size()-1);
        }
    }
}