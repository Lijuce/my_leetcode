class Solution {
    /**
     * 647. 回文子串
     * 动态规划思想解决
     * 注：此题更优解是利用双指针技巧进行中心扩展操作
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int count = 0;
        int slen = s.length();
        boolean[][] dp = new boolean[slen][slen];
        // dp数组定义：以s[i]和s[j]为首尾的字符串是否回文子串
        // 三种可能性：
        // 1. 当 i == j，即单个字符串本身就是回文串；
        // 2. 当 j - i = 1, 即长度为2的字符串时，要求两个字符相同，才是回文串
        // 3. 当 j-i>1，即长度大于2的字符串时，先判断首尾字符是否相同，若相同则再判断其内部子串是否为回文串(即[i+1]..[j-1]是否true)
        for (int j = 0; j < slen; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j){
                    dp[i][j] = true;
                    count ++;
                }else if (j-i == 1 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    count ++;
                }else if (j-i > 1 && s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    count ++;
                }
            }
        }

        // 优化
        for (int j = 0; j < slen; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j))
                    if (i == j || j-i == 1 || dp[i+1][j-1]) {
                        dp[i][j] = true;
                        count ++;
                    }
            }
        }
        return count;
    }
}