class Solution {
    /**
     * 暴力解法：先判断并截取回文子串，然后记录长度
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);

            if (s1.length() > res.length()) {
                res = s1;
            }
            if (s2.length() > res.length()) {
                res = s2;
            }
        }
        return res;
    }

    // 判断是否回文串并进行截取
    public String palindrome(String s, int l, int r) {
        while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
            l -= 1;
            r += 1;
        }
        return s.substring(l + 1, r);
    }
}

class Solution2 {
    /**
     * 二维数组-DP动态规划
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

        // 定义最长回文串的长度
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
                if (dp[i][j] && j-i+1 > maxLen) {
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
