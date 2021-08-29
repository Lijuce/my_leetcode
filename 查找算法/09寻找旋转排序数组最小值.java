class Solution {
    /**
     * 154. 寻找旋转排序数组中的最小值 II
     * 直接简单法
     * @param numbers
     * @return
     */
    public int findMin(int[] numbers) {
        int len = numbers.length;
        if (len <= 1) {
            return numbers[0];
        }
        if (len == 2) {
            return Math.min(numbers[0], numbers[1]);
        }
        int base = numbers[0];
        int resMin = base;
        // 先判断前两个是否旋转，如果没有旋转，则第一个必定是临时最小值
        if (numbers[1] >= base)
            // 从右边开始：进一步寻找真正的最小值，直到比它大的值出现
            for (int i = len-1; i >= 0; i--) {
                resMin = Math.min(resMin, numbers[i]);
                if (numbers[i] > resMin)
                    break;
            }
        else
            return numbers[1];
        return resMin;
    }
}


class Solution2 {
    /**
     * 二分法
     * @param numbers
     * @return
     */
    public int findMin(int[] numbers) {
        int len = numbers.length;
        int left = 0;
        int right = len - 1;

        int mid = 0;
        // 以右边界数为基准进行比对
        while (left <= right) {
            mid = (left + right) / 2;
            // 说明最小值在中点右边，因此忽略左边部分
            if (numbers[mid] > numbers[right])
                left = mid + 1;
            // 说明最小值在中点左边，因此忽略右边部分
            // 但是不能减1，因为有可能恰好就是最小值
            else if (numbers[mid] < numbers[right])
                right = mid;
            // 可能有重复值
            else
                right --;
        }
        // 由于是递增序列，因此目标是左边界为下标的值
        return numbers[left];
    }
}