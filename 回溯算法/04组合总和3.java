class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    /**
     * 216. 组合总和3
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        drawBack(n, k, 0, 1);
        return res;
    }

    private void drawBack(int n, int k, int val, int start) {
        if (temp.size() == k && val == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // 组合超过K，不符合题意
        if (temp.size() > k)
            return;
        // 重点：此处的剪枝操作
        // i <= n-(k-temp.size())+1
        for (int i = start; i <= 9; i++) {
            // 选择
            temp.add(i);
            val += i;

            drawBack(n, k, val, i+1);

            // 回撤选择
            val -= i;
            temp.remove(temp.size()-1);
        }
    }
}