class Solution {
    List<List<Integer>> res = new ArrayList<>();

    /**
     * 102. 二叉树的层序遍历
     * 采用队列保证顺序，同一层先左后右遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return res;
        TreeNode curNode = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<Integer> tempList = new ArrayList<>();
        tempList.add(curNode.val);
        while(!queue.isEmpty()) {
            int count = queue.size();
            tempList = new ArrayList<>();
            // 记录同一层的节点数
            while (count > 0) {
                TreeNode tempNode = queue.poll();
                tempList.add(tempNode.val);
                TreeNode leftNode = tempNode.left;
                TreeNode rightNode = tempNode.right;
                if (leftNode != null) {
                    queue.add(leftNode);
                }
                if (rightNode != null) {
                    queue.add(rightNode);
                }
                count --;
            }
            res.add(tempList);
        }
        return res;
    }
}