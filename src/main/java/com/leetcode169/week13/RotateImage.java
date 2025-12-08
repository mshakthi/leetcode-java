package com.leetcode169.week13;

public class RotateImage {
    /**
     * Rotates the given n x n 2D matrix by 90 degrees clockwise in-place.
     * 
     * The rotation is achieved in two steps:
     * 1. Transpose the matrix (convert rows to columns)
     * 2. Reverse each row by swapping columns from outside to inside
     * 
     * @param matrix the n x n 2D matrix to be rotated, modified in-place
     * @throws NullPointerException if matrix is null
     * 
     * Time Complexity: O(n²) where n is the dimension of the matrix
     * Space Complexity: O(1) as the rotation is done in-place
     * 
     * Example:
     * Input:  [[1,2,3],
     *          [4,5,6],
     *          [7,8,9]]
     * Output: [[7,4,1],
     *          [8,5,2],
     *          [9,6,3]]
     */
    public void rotate(int[][] matrix) {
        transpose(matrix);

        int n = matrix.length;

        for(int j=0;j<n/2;j++){
            swap(matrix, j, n - 1 - j);
        }

    }

    public void swap(int[][] matrix, int col1, int col2) {
        int n = matrix.length;

        for(int i =0;i<n;i++){
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
        }
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;

        for(int i =0;i<n;i++){
            for(int j = i ;j< n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
    }
    
}
