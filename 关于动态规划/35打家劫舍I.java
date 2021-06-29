class Solution {
    /**
     * 198. 打家劫舍I
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return len==0? null: nums[0];
        int[] dp = new int[len];
        // DP初始化，选择前两天选多的一天抢
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[len-1];
    }
}

class Solution2 {
    /**
     * 空间优化
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
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