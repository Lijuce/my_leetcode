class Solution {
    List<String> res = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {
        backTrace(s, 0, new ArrayList<String>());
        return res;
    }

    public void backTrace(String s, int startIndex, List<String> track){
        // 当组合的IP超过4个且还有剩余的未进行组合，过滤
        if (track.size() >= 4 && startIndex != s.length())
            return;
        // 当满足IP组合恰好为四个时，加入最终结果
        if (track.size() == 4){
            res.add(String.join(".", track));
            return;
        }
        for (int i = startIndex; i < s.length(); i++){
            String substring = s.substring(startIndex, i + 1);
            if ((substring.length() > 1 && substring.startsWith("0")) || substring.length() > 3)
                break;
            int value = Integer.valueOf(substring);
            if (value > 255)
                break;
            track.add(substring);
            backTrace(s, i+1, track);
            track.remove(track.size()-1);
        }
    }
}