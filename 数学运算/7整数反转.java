class Solution {
    /**
     * 整数反转(要考虑大数溢出情况)
     * 严谨地说，此处应用前应当有个简单的数学推论，即不等式证明
     * @param x
     * @return
     */
    public int reverse(int x) {
        int reverseNums = 0;
        while (x != 0) {
            if (reverseNums > (Integer.MAX_VALUE/10) || reverseNums <(-(Integer.MAX_VALUE+1)/10)) {
                return 0;
            }
            reverseNums *= 10;
            reverseNums = reverseNums + (x % 10);
            x = x / 10;
        }
        return reverseNums;
    }
}