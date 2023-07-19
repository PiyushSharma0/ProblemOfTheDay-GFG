// Link: https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

class Solution {
    public int longestPalinSubseq(String S) {
        int n = S.length();
        int[][] dp = new int[n][n];

        // Each character is a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Consider all substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = (S.charAt(i) == S.charAt(i + 1)) ? 2 : 1;
        }

        // Fill the table for substrings of length 3 or more
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (S.charAt(i) == S.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        // The length of the longest palindromic subsequence in the entire string is stored in dp[0][n-1]
        return dp[0][n - 1];
    }
}
