package com.leetcode169.week15;

public class SetMatrixZeroes {
    /**
     * Sets entire rows and columns to zero in a matrix if any element in that row or column is zero.
     * This method modifies the input matrix in-place.
     * 
     * Algorithm:
     * 1. First pass: Identify all rows and columns that contain at least one zero element
     *    and mark them using boolean arrays.
     * 2. Second pass: Set all elements to zero if they belong to a marked row or column.
     * 
     * Time Complexity: O(m * n) where m is the number of rows and n is the number of columns
     * Space Complexity: O(m + n) for the two boolean arrays
     * 
     * @param matrix a 2D integer array representing the matrix to be modified.
     *               The matrix must have at least one row and one column.
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(matrix[i][j] ==0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}
