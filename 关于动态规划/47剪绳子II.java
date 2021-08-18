class Solution {
    /**
     * 剑指 Offer 14- II. 剪绳子 II
     * 此法为贪心算法，需要通过数学证明知晓截取长度为3是最优解
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n < 4)
            return n-1;
        if (n == 4)
            return 4;
        long res = 1;
        while (n > 4) {
            // 每次截取长度3
            res = res * 3 % 1000000007;
            n -= 3;
        }
        return (int)(res*n % 1000000007);
    }
}