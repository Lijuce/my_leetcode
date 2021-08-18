class Solution {
    /**
     * 494目标和：
     * 注意题目转化：易知left+right = sum 且 left-right=target，其中left和right都是正数集合
     * 可推导出 left=(sum+target)/2，即求组合目标为left的组合方式有多少种
     * 将left看成新的target，即以target为目标，从nums中寻找任意个数的和为target
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

        // 此处的bagSize即为上面提到的新target
        int bagSize = (sum + target) / 2;
        // 此处看作背包问题。求有多少种不同的装法，能够将容量为bagSize的背包装满。
        // 待选的物品从nums中选取，nums表各自的容量
        // DP定义：dp[i][j]表针对前i个数，当背包容量为j时，最多有多少种不同方式可以将背包装满
        int[][] dp = new int[nums.length+1][bagSize+1];
        // DP初始化：容量为0时，不装也是一种装法
        for (int i = 0; i < nums.length+1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j < bagSize + 1; j++) {
                int num = nums[i-1];
                if (j - num < 0) {
                    // 背包余下空间不够装，则与之前 不考虑当前数i 的装法相同
                    dp[i][j] = dp[i-1][j];
                } else {
                    // 背包余下空间充足，则根据前面装过的方式，将两种装法相加
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-num];
                }
            }
        }
        return dp[nums.length][bagSize];

//        int[] dp = new int[bagSize+1];
//        dp[0] = 1;
//        // TODO：下面的循环还需多理解
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = bagSize; j >= nums[i]; j--) {
//                dp[j] = dp[j] + dp[j - nums[i]];
//            }
//        }
//        return dp[bagSize];
    }
}