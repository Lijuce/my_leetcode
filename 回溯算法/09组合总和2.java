// 40. 组合总和 II

class Solution {
    List<Integer> track = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, 0);
        return res;
    }

    public void backTrack(int[] candidates, int target, int j){
        if (target==0){
            res.add(new ArrayList<> (track));
            return;
        }

        for (int i=j; i<candidates.length; i++){
            if (target-candidates[i] < 0) break;  // 剪枝
            if (i>j && candidates[i]==candidates[i-1])  // 此处是去重关键之处
                continue;
            track.add(candidates[i]);
            backTrack(candidates, target-candidates[i], i+1);
            track.remove(track.size()-1);
        }
    }
}