class Solution {
    // public int[] countBits(int n) {
    //     int[] binaryList = new int[n+1];
    //     if (n < 1){
    //         return binaryList;
    //     }
    //     for (int i = 1; i <= n; i++) {
    //         if (i > 8 && i % 8 > 0){
    //             binaryList[i] = binaryList[i/8] + binaryList[i%8];
    //         }else {
    //             binaryList[i] = countBit(i);
    //         }
    //     }
    //     return binaryList;
    // }
    // public static int countBit(int num){
    //     int temp = 0;
    //     int yushu;
    //     while (num > 0){
    //         yushu = num % 2;
    //         num = num / 2;
    //         if (yushu > 0){
    //             temp ++;
    //         }
    //     }
    //     return temp;
    // }

    /**
     * 338. 比特位计数
     * 此题的DP思想依旧在于利用已计算过的比特位
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++){
            // 位运算规律。
            // i右移1位，必定比原来小，那么就是计算过的比特位。
            // 最低位为1，则在原基础上+1；否则不加1
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}