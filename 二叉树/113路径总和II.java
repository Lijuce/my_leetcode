class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> track = new ArrayList<>();

    /**
     * 113. 路径总和 II
     * 深度遍历优先
     * 回溯法
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int sum = 0;
        dfs(root, sum, targetSum);
        return res;
    }

    public void dfs(TreeNode root, int sum, int targetSum){
        if (root == null)
            return ;

        sum += root.val;
        track.add(root.val);

        if (root.left == null && root.right == null)
            if (targetSum == sum)
                res.add(new ArrayList(track));

        dfs(root.left, sum, targetSum);
        dfs(root.right, sum, targetSum);
        track.remove(track.size() - 1);  // 回撤
    }
}    