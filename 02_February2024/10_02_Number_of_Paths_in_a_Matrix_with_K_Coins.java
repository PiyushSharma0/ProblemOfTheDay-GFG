// Link: https://practice.geeksforgeeks.org/problems/number-of-paths-in-a-matrix-with-k-coins/0
// Time Complexity: O(n^2 * k)
// Space Complexity: O(n^2 * k)

class Solution {
    long numberOfPath(int n, int k, int[][] arr) {
       
       long[][][] dp = new long[n][n][k+1];
       
       for(long[][] matrix : dp)
         for(long[] row : matrix)
            Arrays.fill(row, -1);
         
       return helper(n - 1, n - 1, k, arr, dp);
    }
    
    private long helper(int i, int j, int k, int[][] arr, long[][][] dp) {
        // Check if we reached the bottom-right corner and collected exactly k coins
        if (i == 0 && j == 0 && k == arr[i][j]) {
            return 1;
        }
        
        // If k becomes negative or we move out of the matrix boundaries, return 0
        if (i < 0 || j < 0 || k < 0) {
            return 0;
        }
        
        if(dp[i][j][k]!=-1)
          return dp[i][j][k];
        
        // Calculate the number of paths by moving up and left
        return dp[i][j][k] = helper(i - 1, j, k - arr[i][j], arr, dp) + helper(i, j - 1, k - arr[i][j], arr, dp);
    }
}