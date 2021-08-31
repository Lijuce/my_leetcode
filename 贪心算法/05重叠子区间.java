class Solution {
    /**
     * 435无重叠区间
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2)
            return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 0;
        int right = intervals[0][1];

        int ans = 1;
        int len = intervals.length;
        for (int i = 1; i < len; i ++) {
            // 直接计算最多保留多个非重叠区间
            if (intervals[i][0] >= right) {
                ans++;
                right = intervals[i][1];
            }
        }
        // 剩余的就是要去除的区间数量
        return len-ans;
    }
}