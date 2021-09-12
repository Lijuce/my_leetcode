class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    /**
     * 77. 组合
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        drawBack(n, k, 1);
        return res;
    }

    private void drawBack(int n, int k, int start) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return ;
        }
        // 重点：此处的剪枝操作
        // i <= n-(k-temp.size())+1
        for (int i = start; i <= n-(k-temp.size())+1; i++) {
            temp.add(i);

            drawBack(n, k, i+1);

            temp.remove(temp.size()-1);
        }
    }
}