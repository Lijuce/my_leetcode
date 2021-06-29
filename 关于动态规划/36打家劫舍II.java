class Solution {
    /**
     * 213. 打家劫舍 II
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;
        int[] nums1 = new int[len-1];
        int[] nums2 = new int[len-1];
        for (int i = 0; i < len-1; i++) {
            nums1[i] = nums[i];
        }
        for (int i = 1; i < len; i++) {
            nums2[i] = nums[i];
        }
        // 掐头去尾比较最终所劫金额
        return Math.max(robDP(nums1), robDP(nums2));
    }

    public int robDP(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return len==0? null: nums[0];
        int dpi0 = nums[0];
        int dpi1 = Math.max(nums[0], nums[1]);
        int dpi = 0;
        for (int i = 2; i < len; i++) {
            dpi = Math.max(dpi1, dpi0 + nums[i]);
            dpi0 = dpi1;
            dpi1 = dpi;
        }
        return Math.max(dpi0, dpi1);
    }
}

