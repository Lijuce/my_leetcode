class solution{
    /**
     * 归并排序算法
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right , int[] temp){
        if (left < right){
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);  // 左边递归地归并排序
            mergeSort(arr, mid+1, right, temp);  // 右边递归地归并排序
            merge(arr, left, mid, right, temp);  // 左右两边最后进行归并
        }
    }
    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int tempIndex = 0;
        int leftStartIndex = left, rightStartIndex = mid+1;
        while (leftStartIndex <= mid && rightStartIndex <= right){  // 将两边的数组值一一比较
            if (arr[leftStartIndex] < arr[rightStartIndex])
                temp[tempIndex++] = arr[leftStartIndex++];
            else
                temp[tempIndex++] = arr[rightStartIndex++];
        }
        while (leftStartIndex <= mid){  // 左边还有剩余，将剩余全部拷贝至临时数组
            temp[tempIndex++] = arr[leftStartIndex++];
        }
        while (rightStartIndex <= right){  // 右边还有剩余，做法同上
            temp[tempIndex++] = arr[rightStartIndex++];
        }
        for (int i = 0; i < tempIndex; i++) {  // 最后赋回给原数组
            arr[left+i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {22,33,49,47,33,12,68,29,22};
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        for (int n: nums)
            System.out.println(n);
    }
}
