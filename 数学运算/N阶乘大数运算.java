class solution {
    /**
     * N阶乘计算
     * 此题虽简单，但是需要考虑到数值溢出问题，即涉及到大数运算
     * 较好的做法是用数组将运算结果的每个位数进行存储
     * @param n
     */
    private static void NFactorial(int n) {
        int[] arr = new int[100];
        int result = 1;
        if (n <= 1) {
            System.out.println(1);
            return ;
        }
        arr[0]=1;
        for (int i = 2; i <= n; i++) {
            int up = 0;
            for (int j = 0; j < 100; j++) {
                // 核心
                int s = arr[j]*i+up;
                arr[j] = s%10;
                up = s/10;
            }
        }
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] != 0) {
                for (int j = i; j >= 0; j--) {
                    System.out.print(arr[j]);
                }
                break;
            }
        }
    }
}