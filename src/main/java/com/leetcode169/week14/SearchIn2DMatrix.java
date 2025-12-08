package com.leetcode169.week14;

public class SearchIn2DMatrix {
    /**
     * Searches for a target value in a 2D matrix using binary search.
     * 
     * <p>The matrix has the following properties:
     * <ul>
     *   <li>Integers in each row are sorted from left to right.</li>
     *   <li>The first integer of each row is greater than the last integer of the previous row.</li>
     * </ul>
     * 
     * <p>The algorithm treats the 2D matrix as a flattened 1D sorted array and performs
     * binary search by converting the mid index to row and column coordinates:
     * <ul>
     *   <li>row = mid / n (number of columns)</li>
     *   <li>col = mid % n (number of columns)</li>
     * </ul>
     * 
     * @param matrix a 2D integer matrix with m rows and n columns, sorted in ascending order
     * @param target the integer value to search for in the matrix
     * @return true if the target exists in the matrix, false otherwise
     * 
     * @throws ArrayIndexOutOfBoundsException if the matrix is empty
     * 
     * <p>Time Complexity: O(log(m*n)) where m is the number of rows and n is the number of columns
     * <p>Space Complexity: O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left =0;
        int right = m*n -1;

        while(left<=right) {
            int mid = left + (right - left)/2;
            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] < target) {
                left = mid +1;
            } else {
                right = mid -1;
            }

        }
        
        return false;
    }
}
