public class Main {
    /**
     * 33. 搜索旋转排序数组
     * 该题的思路本质还是二分搜索，只不过在二分搜索之前需要判断哪个区间是有序的
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {
                // 说明右半段是有序的，在此处进行二分搜索
                if (nums[mid] < target && target <= nums[right]) {
                    // target即是在此区间
                    left = mid + 1;
                } else {
                    // target不在此区间
                    right = mid - 1;
                }
            } else {
                // 说明左半段是有序的，在此处进行二分搜索
                if (nums[left] <= target && target < nums[mid]) {
                    // target 是在区间
                    right = mid - 1;
                } else {
                    // target不在此区间
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}