class Solution {
    /**
     * 516. 最长回文子序列
     * 难点一：dp数组的定义
     * 难点二：遍历方式有所不同，可选择斜着遍历/反向遍历
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        // dp初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        // 当两边的字母不同，必定不会同时在子序列中，此时需进行最优选择
        // 当两边的字母相同，则回文子序列长度+2
        for (int i = len-1; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
            }
        }
        return dp[0][len-1];
    }
}