public int[] twoSum(int[] numbers, int target){
    int left = 0, right = numbers.length - 1;
    int sum_val;

    while (left <= right){
        sum_val = numbers[left] + numbers[right];    
        if (sum_val == target){
            return new int[]{left + 1, right + 1};
        }
        else if (sum_val > target)
            right -= 1;
        else if (sum_val < target)
            left += 1;
    }
    return new int[]{-1, -1};
}
