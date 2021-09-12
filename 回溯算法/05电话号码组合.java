class Solution {
    List<String> res = new ArrayList<>();
    StringBuffer temp = new StringBuffer();

    /**
     * 17. 电话号码的字母组合
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() < 1)
            return res;
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        drawBack(digits, numString, 0);
        return res;

    }

    private void drawBack(String digits, String[] numString, int num) {
        if (num == digits.length()) {
            res.add(temp.toString());
            return;
        }
        int n = digits.charAt(num) - '0';
        String str = numString[n];

        for (int i = 0; i < str.length(); i++) {
            // 选择
            temp.append(str.charAt(i));
            // 下一个数字的字母组合
            // 注意此处是 num+1
            drawBack(digits, numString, num+1);
            // 回撤选择
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}