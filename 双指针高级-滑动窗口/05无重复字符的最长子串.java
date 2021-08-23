class Solution {
    /**
     * 3. 无重复字符的最长子串
     * 滑动窗口技巧
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;

        int sLen = s.length();
        int resMaxLen = 0;
        // 先将所有字符映射成字典
        for (int i = 0; i < sLen; i++)
            map.put(s.charAt(i), 0);
        while (right < sLen) {
            char sTemp = s.charAt(right);
            right ++;
            map.put(sTemp, map.get(sTemp)+1);

            while (map.get(sTemp) > 1) {
                char temp = s.charAt(left);
                // 左窗口缩小
                left ++;
                // 重复字符的频次减1
                map.put(temp, map.get(temp)-1);
            }
            // 最大长度
            resMaxLen = Math.max(resMaxLen, right-left);
        }
        return resMaxLen;
    }
}