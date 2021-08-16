public class quick_sort {

    public static void main(String[] args) {
	// write your code here
        int[] nums = new int[]{22,33,49,47,33,12,68,29};
        quickSort(nums, 0, nums.length - 1);
        for (int i: nums)
            System.out.println(i);
    }

    public static void QuickSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }

        int base = nums[left];
        int l = left, r = right;
        while (l != r){
            while (l < r && nums[r] >= base)
                r --;
            while (l < r && nums[l] <= base)
                l ++;
            if (l < r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        nums[left] = nums[r];
        nums[r] = base;
        QuickSort(nums, left, l - 1);
        QuickSort(nums, r + 1, right);
    }


}
