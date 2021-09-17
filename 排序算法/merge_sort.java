package com.sort;

/**
 * @ClassName mergeSort
 * @Description TODO
 * @Author Lijuce_K
 * @Date 2021/9/15 21:01
 * @Version 1.0
 **/
public class mergeSort {
    public static void main(String[] args) {
        int[] nums = {22,33,49,47,33,12,68,29,22};
        callSort(nums);
        for(int n: nums)
            System.out.println(n);
    }

    public static void callSort(int[] array) {
        mergeSort(array, 0, array.length-1);
    }

    public static void mergeSort(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            mergeSort(array, left, mid);
            mergeSort(array, mid+1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right-left+1];
        int leftStartIdx = left;
        int rightStartIdx = mid+1;
        int idx = 0;
        while (leftStartIdx <= mid && rightStartIdx <= right) {
            if (array[leftStartIdx] < array[rightStartIdx]) {
                temp[idx++] = array[leftStartIdx++];
            } else {
                temp[idx++] = array[rightStartIdx++];
            }
        }
        while (leftStartIdx <= mid) {
            temp[idx++] = array[leftStartIdx++];
        }
        while (rightStartIdx <= right) {
            temp[idx++] = array[rightStartIdx++];
        }
        for (int i = 0; i < idx; i++) {
            array[left+i] = temp[i];
        }
    }
}
