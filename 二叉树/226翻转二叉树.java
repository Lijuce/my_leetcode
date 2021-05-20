
/**
 * 热门100
 */
class Solution {
    /**
     * 226. 翻转二叉树
     * 前序遍历递归
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        // case
        if (root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

class Solution2 {
    /**
     * 226. 翻转二叉树
     * 层次遍历-广度优先法
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        // 特判
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if (curNode.left != null || curNode.right != null){
                // 进行翻转
                TreeNode temp = curNode.left;
                curNode.left = curNode.right;
                curNode.right = temp;

                if (curNode.left != null)
                    queue.offer(curNode.left);
                if (curNode.right != null)
                    queue.offer(curNode.right);

            }
        }
        return root;
    }
}