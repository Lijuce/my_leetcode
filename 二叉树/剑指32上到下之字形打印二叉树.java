class Solution {
    Deque<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> results = new ArrayList<>();
    /**
     * 剑指32.上到下打印二叉树-之字形
     * 层序遍历+双端队列（奇偶层逻辑分离）
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root != null)
            queue.add(root);
        List<Integer> temp;
        while (!queue.isEmpty()){
            temp = new ArrayList<>();
            // 先打印奇数层
            for (int i = queue.size(); i > 0; i--){
                // 从左向右打印
                TreeNode node = queue.removeFirst();
                temp.add(node.val);
                // 从左向右加入子层节点
                if (node.left != null)
                    queue.addLast(node.left);
                if (node.right != null)
                    queue.addLast(node.right);
            }
            results.add(temp);
            if (queue.isEmpty())
                break;
            temp = new ArrayList<>();
            // 再打印偶数层
            for (int i = queue.size(); i > 0; i--){
                // 从右向左打印
                TreeNode node = queue.removeLast();
                temp.add(node.val);
                // 从右向左加入子层节点
                if (node.right != null)
                    queue.addFirst(node.right);
                if (node.left != null)
                    queue.addFirst(node.left);
            }
            results.add(temp);
        }
        return results;
    }
}

class Solution2 {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> results = new ArrayList<>();
    /**
     * 剑指32.上到下打印二叉树-之字形
     * 层序遍历+奇数层倒序
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(results.size() % 2 == 1) Collections.reverse(tmp);  // 若为奇数层则对结果进行倒序
            results.add(tmp);
        }
        return results;
    }
}