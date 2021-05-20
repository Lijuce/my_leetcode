class Solution {
    /**
     * 热门100
     * 114. 二叉树展开为链表
     * 后续遍历递归
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        flatten(root.left);
        flatten(root.right);

        TreeNode tmp = root.right;
        root.right = root.left;
//        root.left.right = tmp;
//        root.left = null;
        root.left = null;
        TreeNode p = root;
        while(p.right != null)
            p = p.right;
        p.right = tmp;
    }
}    