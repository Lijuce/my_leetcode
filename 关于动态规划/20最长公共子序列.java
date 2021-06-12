class Solution {
    /**
     * 1143. 最长公共子序列
     * dp定义：二维数组，每一维代表相应的子序列
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int lenS1 = text1.length();
        int lenS2 = text2.length();
        // dp定义：text1的第i个字母为结尾与text2第j个字母为结尾所对应的最长公共子序列
        int[][] dp = new int[lenS1+1][lenS2+1];
        dp[0][0] = 0;
        // 比较时三种情况：(注意索引偏移)
        // 1. 两个字母相同，那么自然+1
        // 2. 两者不同，假设text1[i]的字母不符合公共序列条件，j右移1位，i保持不变，体现在数组即[i-1][j](索引偏移)
        // 3. 两者不同，假设text2[j]的字母不符合公共序列条件，i右移1位，j保持不变，体现在数组即[i][j-1](索引偏移)
        for (int i = 1; i < lenS1 + 1; i++) {
            for (int j = 1; j < lenS2 + 1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[lenS1][lenS2];
    }
}