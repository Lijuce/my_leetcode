class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> trace = new LinkedList<>();

    /**
     * 全排列问题-初识回溯算法
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        dfs(nums, trace, visited);

        return res;
    }

    private void dfs(int[] nums, LinkedList<Integer> trace, boolean[] visited) {
        if (nums.length == trace.size())
            res.add(new ArrayList<>(trace));

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            trace.add(nums[i]);

            dfs(nums, trace, visited);

            visited[i] = false;
            trace.removeLast();
        }
    }
}