<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<String> res = new ArrayList<>();

    /**
     * 93复原ip地址-字符串转有效ip
     * 较为常规的回溯算法
     *
     * @param s
     * @return
     */
=======
class Solution {
    List<String> res = new ArrayList<String>();

>>>>>>> origin/main
    public List<String> restoreIpAddresses(String s) {
        backTrace(s, 0, new ArrayList<String>());
        return res;
    }

<<<<<<< HEAD
    public void backTrace(String s, int startIndex, List<String> track) {
        // 组合成IP地址的4个子地址无效性排除
        if (track.size() >= 4 && startIndex != s.length()) {
            return;
        }
        // 4个合理的子地址刚好组合成IP
        if (track.size() == 4) {
            res.add(String.join(".", track));
        }
        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i + 1);
            // 排除无效情况，包括：0开头的长度大于2的ip，以及字长度大于3的ip
            if (substring.length() > 1 && substring.startsWith("0") || substring.length() > 3) {
                break;
            }
            Integer value = Integer.valueOf(substring);
            // IP地址内超过255为无效ip
            if (value > 255) {
                break;
            }
            track.add(substring);
            backTrace(s, i + 1, track);
            // 回撤选择
            track.remove(track.size() - 1);
=======
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
>>>>>>> origin/main
        }
    }
}