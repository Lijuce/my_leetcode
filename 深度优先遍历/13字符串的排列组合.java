import java.util.*;

/**
    BM58 字符串的排列
    题目链接(牛客网)：https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=295&tqId=23291&ru=/practice/0c9664d1554e466aa107d899418e814e&qru=/ta/format-top101/question-ranking
 */
public class Solution {
    ArrayList<String> res = new ArrayList<>();
    char[] arr;
    public ArrayList<String> Permutation(String str) {
       if (str == null || str.length() == 0) {
           return null;
       }
       arr = str.toCharArray();
       dfs(0);
       return res;
    }
    
    public void dfs(int j) {
        if (j == arr.length-1) {
            res.add(String.valueOf(arr));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = j; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                continue;
            }
            set.add(arr[i]);
            swap(arr, i, j);
            dfs(j+1);
            swap(arr, i, j);
        }
    }
    
    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
