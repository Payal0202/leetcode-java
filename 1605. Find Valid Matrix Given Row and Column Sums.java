class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length; // number of rows
        int n = colSum.length; // number of columns
        int[][] mat = new int[m][n]; // result matrix

        // Iterate over each cell of the matrix
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // Fill the current cell with the minimum of the remaining row sum and column sum
                mat[i][j] = Math.min(rowSum[i], colSum[j]);
                
                // Subtract the assigned value from both rowSum and colSum
                rowSum[i] -= mat[i][j];
                colSum[j] -= mat[i][j];
            }
        }

        return mat; // return the resulting matrix
    }
}


// Time Complexity: O(m*n)
// Space Complexity: O(m*n)
