class Solution {
    /**
     * 116. 填充每个节点的下一个右侧节点指针
     * 递归法连接左右邻居节点
     * @param root
     * @return
     */
    public TreeNode connect(TreeNode root) {
        // 递归结束条件
        if (root == null)
            return root;

        ConnectTwo(root.left, root.right);
        return root;
    }
    public void ConnectTwo(TreeNode a, TreeNode b){
        if (a == null || b == null)
            return ;
        a.next = b;  // next指向右侧的邻居节点

        ConnectTwo(a.left, a.right);  // 先连接同一父节点的子节点
        ConnectTwo(b.left, b.right);
        ConnectTwo(a.right, b.left);  // 再连接跨父节点的子节点
    }
}