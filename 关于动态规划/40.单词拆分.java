class Solution {
    /**
     * 139. 单词拆分
     * 思想类似于背包问题
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // dp[i]定义：每个前i-1个字母可否成功进行单词拆分
        boolean[] dp = new boolean[len+1];
        // 第一个为空字符串，默认可拆分
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}