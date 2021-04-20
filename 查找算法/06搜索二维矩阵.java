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