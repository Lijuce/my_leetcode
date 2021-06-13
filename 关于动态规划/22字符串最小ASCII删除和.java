class Solution {
    /**
     * 712. 两个字符串的最小ASCII删除和
     * 思路类似于最大公共子序列
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum(String s1, String s2) {
        int lenW1 = s1.length();
        int lenW2 = s2.length();
        int[][] dp = new int[lenW1+1][lenW2+1];
        // dp数组定义：每个i和j对应的所需删除的字母Aiscii最小和
        // dp初始化
        dp[0][0] = 0;
        for (int i = 1; i < lenW1 + 1; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }
        for (int i = 1; i < lenW2 + 1; i++) {
            dp[0][i] = dp[0][i-1] + s2.charAt(i-1);
        }

        for (int i = 1; i < lenW1 + 1; i++) {
            for (int j = 1; j < lenW2 + 1; j++) {
                if (s1.charAt(i-1) != s2.charAt(j-1))
                    dp[i][j] = Math.min(dp[i-1][j]+s1.charAt(i-1), dp[i][j-1]+s2.charAt(j-1));
                else
                    dp[i][j] = dp[i-1][j-1];
            }
        }
        return dp[lenW1][lenW2];
    }
}