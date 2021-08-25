class Solution {
    /**
     * 215. 数组中的第K个最大元素
     * 法一：暴力搜索，调库快速排序后直接索引查找
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

class Solution2 {
    Random random = new Random();

    /**
     * 法二：快速选择算法（有点像快速排序的思想）
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    private int partition(int[] arr, int left, int right) {
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(arr, left, randomIndex);
        }
        int l = left;
        int base = arr[left];
        for (int i = left+1; i <= right; i++) {
            if (arr[i] < base) {
                l ++;
                swap(arr, i, l);
            }
        }
        swap(arr, l, left);
        return l;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}