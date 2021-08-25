class Solution {
    List<List<Integer>> res = new ArrayList<>();

    /**
     * 15. 三数之和
     * 利用双指针+排序的思想解决
     * 双指针不断将窗口变小，以此寻找边界值
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (len < 3)
            return res;
        int[] tempArr = new int[3];
        // 先进行排序，升序
        Arrays.sort(nums);
        //
        for (int i = 0; i < len; i++) {
            // 排序后第一个元素大于零，则不可能有组合
            if (nums[i] > 0)
                return res;
            // 此处也需要做去重工作，和后面的去重性质是一样的
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    // 需要将值缩小一点，即右指针往左移
                    right --;
                }
                else if (sum < 0) {
                    // 需要将值增大一点，即左指针往右移
                    left ++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 此处做去重，直接跳过邻居相同值的情况
                    while (right > left && nums[right] == nums[right - 1])
                        right --;
                    while (right > left && nums[left] == nums[left+1])
                        left ++;
                    right --;
                    left ++;
                }
            }
        }
        return res;
    }
}