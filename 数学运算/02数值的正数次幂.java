class Solution {
    /**
     * 剑指 Offer 16. 数值的整数次方
     * 最优解法：二分思想（快速幂）
     * 其中涉及一点数学式子证明，再结合位运算
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x ==0)
            return 0;
        double res = 1;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b&1) == 1)
                res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}