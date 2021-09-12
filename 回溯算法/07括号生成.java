class Solution {
    private List<String> res = new ArrayList<String>();
    private StringBuilder track = new StringBuilder();

    /**
     * 22. 括号生成
     * 此题虽然也是经典的回溯思想，但是因为括号的独特性，需要引入左右变量代表左右括号各自的数量
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        drawBack(n,0,0);
        return res;
    }

    // left和right代表左右括号各自的数量
    private void drawBack(int n, int left, int right) {
        // 当括号数量不小于n时，应当结束递归并进行回撤
        if (left < right || left > n || right > n)
            return;
        if (left == n && right == n) {
            res.add(track.toString());
            return;
        }
        // 左括号做选择
        if (left < n) {
            // 选择
            track.append("(");
            drawBack(n, left+1, right);
            // 回撤选择
            track.deleteCharAt(track.length()-1);
        }
        // 右括号做选择
        if (right < n) {
            // 选择
            track.append(")");
            drawBack(n, left, right+1);
            // 回撤选择
            track.deleteCharAt(track.length()-1);
        }
    }
}