class Solution {
    /**
     * 剑指 Offer 33. 二叉搜索树的后序遍历序列
     * 根据二叉搜索树的性质，利用递归法不断检查根节点左右子树是否满足条件
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2)
            return true;
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] arr, int left, int right) {
        if (left >= right)
            return true;
        int rootValue = arr[right];
        // 找到第一个大于根节点值的数，而后续区域数值都在其右子树中
        int rightIdx = left;
        while (rightIdx < right && arr[rightIdx] < rootValue){
            rightIdx++;
        }
        // 检查右子树是否所有值大于根节点
        for (int i = rightIdx; i < right; i++) {
            if (arr[i] <= rootValue) {
                return false;
            }
        }
        // 检查左右子树的各自的孩子树
        if (!verify(arr, left, rightIdx-1)) {
            return false;
        }
        if (!verify(arr, rightIdx, right-1)) {
            return false;
        }
        return true;
    }
}