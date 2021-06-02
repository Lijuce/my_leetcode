class Solution {
    /**
     * 最基本的二分查找，不限边界。
     * @param arr
     * @param target
     * @return
     */
    public static int search(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] < target)
                left = mid + 1;
            else if (arr[mid] > target)
                right = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * 右边界二分查找
     * @param arr
     * @param target
     * @return
     */
    public static int RightBoundSearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] < target)
                left = mid + 1;
            else if (arr[mid] > target)
                right = mid - 1;
            else if (arr[mid] == target)
                left = mid + 1;  // 收缩左侧边界
        }
        if (right < 0 || arr[right] != target)
            return -1;
        return right;
    }
    
    /**
     * 左边界二分查找
     * @param arr
     * @param target
     * @return
     */
    public static int LeftBoundSearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] < target)
                left = mid + 1;
            else if (arr[mid] > target)
                right = mid - 1;
            else if (arr[mid] == target)
                right = mid - 1;  // 收缩右侧边界
        }
        if (left >= arr.length || arr[left] != target)
            return -1;
        return left;
    }
}