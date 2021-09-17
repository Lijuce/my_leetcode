class Solution {
    /**
     * 318. 最大单词长度乘积
     * 位图法
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int count = 0;
        int len = words.length;
        int[] map = new int[len];
        for (int i = 0; i < len; i++) {
            String temp = words[i];
            for (int j = 0; j < temp.length(); j++) {
                map[i] |= 1 << temp.charAt(j)-'a';
            }
        }

        int max = 0;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if ((map[i] & map[j]) == 0) {
                    max = Math.max(words[i].length()*words[j].length(), max);
                }
            }
        }
        return max;
    }
}