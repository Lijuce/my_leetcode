class Solution {
    /**
     * 剑指 Offer 26. 树的子结构
     * 深度遍历优先(多理解此递归思想)
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        // 1、以节点A为根节点的子树 包含树B
        // 2、树B是树A左子树的子结构
        // 3、树B是树A右子树的子结构
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    public boolean dfs(TreeNode A, TreeNode B){
        // 当节点B为空，说明树B已完成匹配(越过叶子节点)，必包含于树A
        if (B == null)
            return true;
        // 当节点A为空，说明树A先遍历完，而B尚未匹配完全，必不含于树A
        else if (A == null)
            return false;
        // 当节点A和B的值不同，匹配失败
        else if (A.val != B.val)
            return false;
        // 最后，继续判断A和B的左右两边的节点是否都匹配
        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}