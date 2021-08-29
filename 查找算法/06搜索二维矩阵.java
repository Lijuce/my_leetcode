import java.util.Arrays;
import java.util.Stack;

/**
 * 2021年4月20日
 * 74. 搜索二维矩阵
 * 进行两次二分查找思想
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        int rowIndex = Search(matrix, target);
        if (rowIndex <= row){
            while ( left <= right){
                int mid = (left + right) / 2;
                if (matrix[rowIndex][mid] < target)
                    left = mid+1;
                else if (matrix[rowIndex][mid] > target)
                    right = mid - 1;
                else if (matrix[rowIndex][mid] == target)
                    return true;
            }
        }
        return false;
    }

    public int Search(int[][] matrix, int target){
        int left = 0;
        int right = matrix.length - 1;
        int n = matrix[0].length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (matrix[mid][n] < target){
                left = mid + 1;
            }else if(matrix[mid][n] == target){
                return mid;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}

class Solution2 {
    /**
     * 74. 搜索二维矩阵
     * 将二维矩阵转化为一维，索引映射二分查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int xLen = 0;
        int yLen = m*n - 1;
        int left = xLen;
        int right = yLen;
        Stack<Object> objects = new Stack<>();
        objects.p
        int mid = 0;
        int temp = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            temp = matrix[mid/n][mid%n];
            if (target < temp) {
                right = mid - 1;
            } else if (target > temp) {
                left = mid + 1;
            } else if (target == temp) {
                return true;
            }
        }
        return false;
    }
}