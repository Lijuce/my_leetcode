// 39. 组合总和

class Solution {
    private List<Integer> track = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
   
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len==0) return res;
        Arrays.sort(candidates);  // 预先排好序，后面方便剪枝
        backTrack(0, candidates, target);
        return res;
    }

    public void backTrack(int j, int[] candidates, int target){
        if (target == 0){
            res.add(new ArrayList<> (track));
            return;
        }
        // if (target < 0) return;  下面已经剪枝，那么这个就不必了
        for (int i = j; i <= candidates.length - 1; i++){
            if (target-candidates[i] < 0) break;  // 剪枝操作
            track.add(candidates[i]);
            backTrack(i, candidates, target-candidates[i]);
            track.remove(track.size() - 1);
        }
    }
}