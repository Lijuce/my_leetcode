class Solution {
    /**
     * 热门100题之一
     * 437. 路径总和 III
     * 最直接的递归法，但是复杂度高
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        int result = dfs(root, targetSum);  // 从根节点开始搜索
        int leftSize = pathSum(root.left, targetSum);  // 以左节点为根进行搜索
        int rightSize = pathSum(root.right, targetSum);  // 以右节点为根进行搜索
        return result + leftSize + rightSize;  // 三者的结果相加
    }

    public int dfs(TreeNode root, int sum){
        if (root == null)
            return 0;

        sum -= root.val;
        track.add(root);

        int result = sum == 0? 1: 0;
        return result + dfs(root.left, sum) + dfs(root.right, sum);
    }
}

