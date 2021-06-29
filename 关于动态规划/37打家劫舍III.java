class Solution {
    /**
     * 337. 打家劫舍 III
     * 动态规划+二叉树后续遍历框架
     * 思考：由于要求连续操作的节点是非连接，而后续遍历时的左右子节点是隔开的，恰好符合条件
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robTree(TreeNode root){
        if (root == null)
            return new int[]{0, 0};
        int[] leftVal = robTree(root.left);
        int[] rightVal = robTree(root.right);
        int valDo = root.val + leftVal[0] + rightVal[0];
        int valNDo = Math.max(leftVal[0], leftVal[1]) + Math.max(rightVal[0], rightVal[1]);

        return new int[]{valNDo, valDo};
    }
}

