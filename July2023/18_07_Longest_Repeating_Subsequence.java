// Link: https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        int n = str.length();
        // Create a 2D array to store the lengths of longest repeating subsequences
        int[][] dp = new int[n + 1][n + 1];
        
        // Fill the dp array using dynamic programming
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, and the indices are different, add 1 to the previous length
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Otherwise, take the maximum of the lengths of the two previous subsequences
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // The length of the longest repeating subsequence will be at dp[n][n]
        return dp[n][n];
    }
}
