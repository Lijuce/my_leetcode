class Solution {

    /**
     * 53. 最大子序和
     * dp数组的巧妙定义
     * 关键在于状态转移时的两种选择
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int numLen = nums.length;
        // 定义dp：dp[i]即代表nums[i]为结尾的最大子数组的和
        int[] dp = new int[numLen];
        Arrays.fill(dp, 0);
        dp[0] = nums[0];
        // 状态转移核心：
        // 要么自身为一个子数组，要么并入前子数组成为新的子数组，max择优
        for (int i = 1; i < numLen; i++){
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < numLen; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

// 优化空间
class Solution2 {
    public int maxSubArray(int[] nums) {
        int numLen = nums.length;
        // 定义dp：dp[i]即代表nums[i]为结尾的最大子数组的和
        int dp_1 = nums[0];
        int dp_2 = 0;
        // 状态转移核心：
        // 要么自身为一个子数组，要么并入前子数组成为新的子数组，max择优
        int res = dp_1;
        for (int i = 1; i < numLen; i++){
            dp_2 = Math.max(nums[i], dp_1 + nums[i]);
            dp_1 = dp_2;
            res = Math.max(res, dp_1);
        }
        return res;
    }
}