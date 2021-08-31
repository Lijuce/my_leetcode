class Solution {
    List<List<Integer>> res = new ArrayList<>();
    /**
     * 103. 二叉树的锯齿形层序遍历
     * 使用单端队列+奇偶层
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> tempList = new ArrayList<>();
        // 层数
        int level = 0;
        while (!queue.isEmpty()) {
            level ++;
            int count = queue.size();
            tempList = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            while (count > 0) {
                TreeNode tempNode = queue.poll();
                temp.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
                count --;
            }
            if (level % 2 == 0) {
                for (int i = temp.size()-1; i >= 0; i--)
                    tempList.add(temp.get(i));
            } else {
                tempList = temp;
            }
            res.add(tempList);
        }
        return res;
    }
}