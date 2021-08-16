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

