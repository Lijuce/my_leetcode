
/**
 * 2021年4月21日
 * 普通二分查找解法
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = 0;
        while (row < matrix.length && column < matrix[0].length){
            if (BinearySearchMatric(matrix, target, row, column))
                return true;
            // BinearySearchMatric(matrix, target, column);
            row ++;
            column ++;
        }
        return false;
    }

    public boolean BinearySearchMatric(int[][] matrix, int target, int row, int column){
        int[] rowMatrix = matrix[row];
        int left = 0;
        int right = rowMatrix.length - 1;
        
        while (left <= right){
            int mid = (left + right) / 2;
            if (rowMatrix[mid] == target){
                return true;
            }else if (rowMatrix[mid] > target){
                right = mid - 1;
            }else if (rowMatrix[mid] < target){
                left = mid + 1;
            }
        }

        left = 0;
        right = matrix.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (matrix[mid][column] == target){
                return true;
            }else if(matrix[mid][column] < target){
                left = mid + 1;
            }else if(matrix[mid][column] > target){
                right = mid - 1;
            }
        }
        return false;
    }
}

/**
 * 二分法进阶解法(推荐)
 * 以矩阵中心为基准点进行比较，分为四个矩阵块
 */
class Solution {
    private int[][] matrix;
    private int target;

    private boolean searchRec(int left, int up, int right, int down) {
        // this submatrix has no height or no width.
        if (left > right || up > down) {
            return false;
        // `target` is already larger than the largest element or smaller
        // than the smallest element in this submatrix.
        } else if (target < matrix[up][left] || target > matrix[down][right]) {
            return false;
        }

        int mid = left + (right-left)/2;

        // Locate `row` such that matrix[row-1][mid] < target < matrix[row][mid]
        int row = up;
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target) {
                return true;
            }
            row++;
        }

        return searchRec(left, row, mid-1, down) || searchRec(mid+1, up, right, row-1);
    }

    public boolean searchMatrix(int[][] mat, int targ) {
        // cache input values in object to avoid passing them unnecessarily
        // to `searchRec`
        matrix = mat;
        target = targ;

        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        return searchRec(0, 0, matrix[0].length-1, matrix.length-1);
    }
}



/**
 * 巧妙解法：利用二维矩阵的四个顶角特性
 * 从右上角开始出发
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int column = 0;
        while (row >= 0 && column <= matrix[0].length-1){
            if (matrix[row][column] > target){
                row --;
            }else if (matrix[row][column] < target){
                column ++;
            }else if (matrix[row][column] == target)
                return true;
        }
        return false;
    }

}
