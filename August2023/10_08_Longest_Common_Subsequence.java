// Link: https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1
// Time Complexity: O(N * M) where N and M are the lengths of the two input strings
// Space Complexity: O(N * M)

class Solution {
    // Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2) {
        // Create a 2D array to store the lengths of LCS of substrings
        int[][] dp = new int[x + 1][y + 1];
        
        // Fill the dp array using bottom-up approach
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0; // Base case: empty string has LCS length 0
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // Characters match, increment LCS length
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Choose max of two substrings
                }
            }
        }
        
        return dp[x][y]; // Length of LCS of the two input strings
    }
}