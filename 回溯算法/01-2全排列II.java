class Solution {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> trace = new LinkedList<>();

    /**
     * 47. 全排列 II
     * 此时注意要进行去重
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, trace, visited);

        return res;
    }

    private void dfs(int[] nums, LinkedList<Integer> trace, boolean[] visited) {
        if (nums.length == trace.size()) {
            res.add(new ArrayList<>(trace));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            // 去除重复(因为前面已经进行了排序，因此判断相邻进行去重即可)
            if (i > 0 && nums[i] == nums[i-1] && visited[i-1])
                continue;
            // 记录选择
            visited[i] = true;
            trace.add(nums[i]);

            dfs(nums, trace, visited);
            // 回撤选择
            visited[i] = false;
            trace.removeLast();
        }
    }
}