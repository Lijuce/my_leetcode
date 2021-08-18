class Solution1 {
    /**
     * 189旋转数组
     * 法一：双重循环（时间复杂度过大）
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        for (int i = 0; i < k; i++) {
            int temp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
}

class Solution2 {
    /**
     * 解法二：翻转数组（容易理解，且代码简洁）
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        // 1.先整体翻转
        reverse(nums, 0, n-1);
        // 2.翻转前部分
        reverse(nums, 0, k-1);
        // 3.翻转后部分
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}