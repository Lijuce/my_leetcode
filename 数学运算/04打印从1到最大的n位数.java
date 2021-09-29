// 大数相关运算
class Solution {
    /**
     * 剑指 大数打印从1到最大的n位数（此题难度还是较大的）
     * 考察大数运算(涉及技巧：dfs回溯生成全排列+去除前导0)
     * @param n
     * @return
     */
    ArrayList<String> output = new ArrayList<>();
    char[] nums = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    StringBuilder temp = new StringBuilder();

    public ArrayList<String> printNumbers(int n) {
        for (int i = 1; i < n; i++) {
            dfs(0, i);
        }
        return output;
    }
    // dfs回溯法生成全排列
    public void dfs(int n, int len) {
        if (n == len) {
            output.add(temp.toString());
            return;
        }
        // 去除前导0的情况
        int start = n == 0? 1: 0;
        for (int i = start; i < 10; i++) {
            temp.append(nums[i]);
            // 固定下一位数
            dfs(n+1, len);
            // 回撤最后一位
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
