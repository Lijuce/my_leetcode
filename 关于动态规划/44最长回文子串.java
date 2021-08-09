class Solution {    
    /**
     * 动态规划解法-dp二维表格法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        // 定义DP: dp[i][j]表是否回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化(二维表格的对角线)
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // 定义最长回文串的长度(因为任何字符本身就是回文串，所以设置1)
        int maxLen = 1;
        // 回文串起始位置
        int begin = 0;
        // 三种情况：参考回文子串
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                // 记录最大长度，以及起始位置
                if (dp[i][j] && j-i+1 > maxLen) {
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}