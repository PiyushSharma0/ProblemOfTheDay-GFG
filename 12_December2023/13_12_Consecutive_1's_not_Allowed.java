// Link: https://practice.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1#
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    long countStrings(int n) {
        final int MOD = 1000000007;

        // dp[i][0] represents the count of binary strings of length i ending with 0
        // dp[i][1] represents the count of binary strings of length i ending with 1
        long[][] dp = new long[n + 1][2];

        // Base cases
        dp[1][0] = 1;
        dp[1][1] = 1;

        // Fill the dp table
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;  // Strings ending with 0 can end with either 0 or 1
            dp[i][1] = dp[i - 1][0];  // Strings ending with 1 can only come from strings ending with 0
        }

        // Calculate the total count by summing up the counts for strings of length N
        long totalCount = (dp[n][0] + dp[n][1]) % MOD;

        return totalCount;
    }
}
