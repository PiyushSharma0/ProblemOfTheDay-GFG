// Link: https://practice.geeksforgeeks.org/problems/distinct-occurences/1
// Time Complexity: O(n*m)
// Space Complexity: O(n*m)

class Solution {
    int subsequenceCount(String s, String t) {
        int mod = 1000000007;
        int n = s.length();
        int m = t.length();

        // dp[i][j] represents the count of distinct subsequences of t[0...j-1] in s[0...i-1]
        int[][] dp = new int[n + 1][m + 1];

        // Initialize the base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // Empty string is a subsequence of any string
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j]; // Exclude the current character in s

                // If the current characters match, add the count of subsequences from the previous state
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
            }
        }

        return dp[n][m];
    }
}