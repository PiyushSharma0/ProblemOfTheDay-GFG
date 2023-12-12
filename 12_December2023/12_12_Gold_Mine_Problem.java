// Link: https://practice.geeksforgeeks.org/problems/gold-mine-problem2608/1
// Time Complexity: O(N * M) where N is the number of rows and M is the number of columns
// Space Complexity: O(N * M)

class Solution {
    static int maxGold(int n, int m, int M[][]) {
        // Create a dp array to store the maximum gold for each cell
        int[][] dp = new int[n][m];

        // Initialize the last column of dp array with the values from the last column of the mine
        for (int i = 0; i < n; i++) {
            dp[i][m - 1] = M[i][m - 1];
        }

        // Iterate through each column from right to left
        for (int j = m - 2; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                // Calculate the maximum gold that can be collected from the current cell
                dp[i][j] = M[i][j] + Math.max(dp[i][j + 1], Math.max(i > 0 ? dp[i - 1][j + 1] : 0, i < n - 1 ? dp[i + 1][j + 1] : 0));
            }
        }

        // Find the maximum value in the first column of dp array
        int maxGold = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }

        return maxGold;
    }
}
