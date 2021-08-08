class Solution {
    /**
     * 494目标和：
     * 注意题目转化：易知left+right = sum 且 left-right=target，其中left和right都是正数集合
     * 可推导出 left=(sum+target)/2
     * 由此，转化为01背包问题，利用动态规划思想解决
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 表明没有组合方案
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        if (target > sum) {
            return 0;
        }

        int bagSize = (sum + target) / 2;
        // 此处看作背包问题。求有多少种不同的装法，能够将容量为bagSize的背包装满。
        int[] dp = new int[bagSize+1];
        dp[0] = 1;
        // TODO：下面的循环还需多理解
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}