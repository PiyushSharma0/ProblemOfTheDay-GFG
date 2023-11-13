// Link: https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
// Time Complexity: O(M * N)
// Space Complexity: O(M * N)

class Solution {
    // Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X, String Y, int m, int n) {
        // Create a table to store the length of the shortest common supersequence.
        int[][] dp = new int[m + 1][n + 1];

        // Fill the table using dynamic programming.
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The length of the shortest common supersequence is m + n minus the length
        // of the longest common subsequence.
        int lcsLength = dp[m][n];
        int supersequenceLength = m + n - lcsLength;

        return supersequenceLength;
    }
}
