class Solution {
    /**
     * 654构造最大二叉树
     * 前序遍历递归
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return func(nums, 0, nums.length-1);
    }

    /**
     * 用于具体执行构造二叉树
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public TreeNode func(int[] nums, int left, int right){
        if ( left > right)
            return null;
        int maxIndex = left;
        for (int i = left; i <= right; i++){
            if (nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = func(nums, left, maxIndex-1);
        root.right = func(nums, maxIndex+1, right);
        return root;
    }
}