class Solution {
    /**
     * 热门100
     * 105前序与中序遍历序列构造二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1,
                inorder, 0, inorder.length-1);
    }
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                              int[] inorder, int inStart, int inEnd){
        if (preStart > preEnd)
            return null;

        int root_val = preorder[preStart];  // 前序的第一个必是根结点
        TreeNode root = new TreeNode(root_val);  

        // 确定中序的根结点
        int root_index=0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root_val){
                root_index = i;
                break;
            }
        }
        
        int left_size = root_index-inStart;  // 左节点的下标范围
        root.left = buildTree(preorder, preStart+1, preStart+left_size,
                inorder, inStart, root_index-1);  // 先从左节点开始构建
        root.right = buildTree(preorder, preStart+left_size+1, preEnd,
                  inorder, root_index+1, inEnd);  // 再从有节点开始构建
        return root;
    }
}