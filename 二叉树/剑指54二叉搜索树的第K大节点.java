class Solution {
    List<Integer> list = new ArrayList<>();
    int res = 0;
    int n = 0;

    /**
     * 剑指54. 二叉搜索树的第k大节点
     * 不直接用中序遍历思想，而是从右-根-左的思想进行深度优先遍历搜索
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        n = k;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if (root.right != null && n > 0)
            dfs(root.right);
        if (--n == 0){
            // 找到目标值，结束递归
            res = root.val;
            return;
        }
        if (root.left != null && n > 0)
            dfs(root.left);
    }
}