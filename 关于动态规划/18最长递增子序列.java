/**
 * 300. 最长递增子序列
 * 关键之一：dp数组定义
 * @param nums
 * @return
 */
public int lengthOfLIS(int[] nums) {
    int numLen = nums.length;
    // 定义dp：dp[i]即代表num[i]为结尾对应的最长子序列长度
    int[] dp = new int[numLen];
    // 最短子序列至少包括了本身，因此为1
    Arrays.fill(dp, 1);
    for (int i = 0; i < numLen; i++){
        for (int j = 0; j < i; j++){
            if (nums[i] > nums[j])
                dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }
    int res = 0;
    for (int i = 0; i < numLen; i++) {
        res = Math.max(res, dp[i]);
    }
    return res;
}


