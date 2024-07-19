import java.util.*;

//Approach 2:
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> maxCol = new HashSet<>();

        // Step 1: Find the maximum element in each column and add to the set
        for (int j = 0; j < matrix[0].length; j++) {
            int maxm = matrix[0][j];
            for (int i = 0; i < matrix.length; i++) {
                maxm = Math.max(maxm, matrix[i][j]);
            }
            maxCol.add(maxm);
        }

        // Step 2: Find the minimum element in each row and check if it is in the set of column maxima
        for (int i = 0; i < matrix.length; i++) {
            int minm = matrix[i][0];
            for (int j = 0; j < matrix[0].length; j++) {
                minm = Math.min(minm, matrix[i][j]);
            }
            if (maxCol.contains(minm)) {
                res.add(minm);
            }
        }

        return res;
    }
}
// Time Complexity: O(m×n)
// Space Complexity: O(n)


//Approach 1 :
// class Solution {
//     public boolean checkRow(int[][] mat,int mini,int row,int n){
//         for(int i=0;i<n;i++){
//             if(mat[row][i] < mini){
//                 return false;
//             }
//         }
//         return true;
//     }

//     public boolean checkCol(int[][] mat,int maxi,int col,int m){
//         for(int i=0;i<m;i++){
//             if(mat[i][col] > maxi){
//                 return false;
//             }
//         }
//         return true;
//     }

//     public List<Integer> luckyNumbers (int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         List<Integer> ans = new ArrayList<>();

//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 //check row for min
//                 //check col for max
//                 if(checkCol(matrix,matrix[i][j],j,m) && checkRow(matrix,matrix[i][j],i,n)){
//                     ans.add(matrix[i][j]);
//                 }
//             }
//         }
//         return ans;
//     }
// }
// // Time Complexity: O(m×n×(m+n))
// // Space Complexity: O(1) (excluding the output list)
