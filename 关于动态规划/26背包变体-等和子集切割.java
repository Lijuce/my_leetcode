class Solution {
    /**
     * 416. 分割等和子集
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n: nums)
            sum += n;
        // 若和为奇数，则无法满足条件
        if (sum % 2 > 0)
            return false;
        int N = nums.length;
        // DP定义：
        boolean[][] dp = new boolean[N+1][sum/2+1];
        // dp初始化
        for (int i = 0; i < N+1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int w = 1; w < sum / 2 + 1; w++) {
                if (w - nums[i-1] < 0)
                    dp[i][w] = dp[i-1][w];
                else
                    dp[i][w] = dp[i-1][w] || dp[i-1][w-nums[i-1]];
            }
        }
        return dp[N][sum/2];
    }
}