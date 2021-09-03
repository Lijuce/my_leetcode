public class Solution {
    /**
     * 剑指 Offer 15/
     * LC191 位1的个数
     * 位运算思想
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count ++;
            n = n&(n-1);
        }
        return count;
    }
}