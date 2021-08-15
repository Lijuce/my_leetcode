class Solution {
    /**
     * 力扣热门100题之一
     * 617. 合并二叉树
     * 思想：深度遍历优先
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }
    public TreeNode dfs(TreeNode root1, TreeNode root2){
        if (root1 == null || root2 ==null){
            if (root1 != null)  // root1为空，直接用root2给其补上
                return root1;
            return root2;
        }
        root1.val += root2.val;  // 直接将值加至root1中
        root1.left = dfs(root1.left, root2.left);
        root1.right = dfs(root1.right, root2.right);
        return root1;
    }
}

class Solution2 {
    /**
     * 广度优先遍历的迭代法
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 ==null){
            if (root1 != null)  // root1为空，直接用root2给其补上
                return root1;
            return root2;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()){
            TreeNode temp1 = queue.poll();
            TreeNode temp2 = queue.poll();
            temp1.val += temp2.val;

            // 如果两边都不为空，则加入队列中等待下一个迭代
            // 如果左边为空，则将右边的节点直接补充至左边
            if (temp1.left != null && temp2.left != null){
                queue.offer(temp1.left);
                queue.offer(temp2.left);
            }else if (temp1.left == null){
                temp1.left = temp2.left;
            }

            // 同上
            if (temp1.right != null && temp2.right != null){
                queue.offer(temp1.right);
                queue.offer(temp2.right);
            }else if (temp1.right == null){
                temp1.right = temp2.right;
            }
        }
        return root1;
    }
}