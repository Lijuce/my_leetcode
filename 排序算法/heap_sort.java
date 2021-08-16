class Solution {
    static int arrLen ;
    /**
     * 堆排序-大顶堆
     * @param arr
     */
    public static void heapSort(int[] arr){
        buildMaxHeap(arr);  // 首先构建出第一个大顶堆
        for (int i = arr.length-1; i > 0; i--){  // 不断地重新构建
            swap(arr, 0, i);  // 和顶堆元素交换
            arrLen -= 1;  
            adjustHeap(arr, 0);  // 堆调整，确保为大顶堆
        }
    }
    public static void buildMaxHeap(int[] arr){
        int maxIndex = arr.length / 2;
        for (int i = maxIndex; i >= 0; i--){
            adjustHeap(arr, i);
        }
    }

    public static void adjustHeap(int[] arr, int index){
        int left = 2*index + 1;
        int right = 2*index +2;
        int largest = index;
        if (left < arrLen && arr[left] > arr[largest])
            largest = left;
        if (right < arrLen && arr[right] > arr[largest])
            largest = right;
        if (largest != index){  // 堆顶不是最大值，继续调整顶堆
            swap(arr, index, largest);
            adjustHeap(arr, largest);
        }
    }
    public static void main(String[] args) {
        int[] arr = {22,33,49,47,33,12,68,29};
        arrLen = arr.length;
        heapSort(arr);
        for(int n: arr)
            System.out.println(n);
    }
}