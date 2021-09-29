class Solution {
    /**
     * 剑指 Offer 40. 最小的k个数
     * 法一：堆排序思想（优先队列实现）
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认小顶堆，此处需要重写比较器改为大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int n: arr) {
            if (queue.size() < k) {
                queue.offer(n);
            } else if (queue.peek() > n) {
                queue.poll();
                queue.offer(n);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }

        return res;
    }
}

class Solution2 {
    /**
     * 法二：快速排序思想，直接去前K个
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        quickSort(arr, 0, arr.length-1);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int left = l, right = r;
        while (left < right) {
            while (left < right && arr[right] >= arr[l])
                right--;
            while (left < right && arr[left] <= arr[l])
                left++;
            swap(arr, left, right);
        }
        swap(arr, left, l);
        // 递归左(右)子数组执行哨兵划分
        quickSort(arr, l, left-1);
        quickSort(arr, left+1, r);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

class Solution3 {
    /**
     * 法三：基于快速排序的数组划分（最优做法）
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        if (k >= arr.length)
            return arr;
        return quickSort(arr, k, 0, arr.length-1);
    }

    private int[] quickSort(int[] arr, int k, int l, int r) {
        int left = l, right = r;
        while (left < right) {
            while (left < right && arr[right] >= arr[l])
                right--;
            while (left < right && arr[left] <= arr[l])
                left++;
            swap(arr, left, right);
        }
        swap(arr, left, l);
        // 根据k值比较情况，递归左(右)子数组执行哨兵划分
        if (left > k)
            quickSort(arr, k, l, left-1);
        if (left < k)
            quickSort(arr, k, left+1, r);
        return Arrays.copyOf(arr, k);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}