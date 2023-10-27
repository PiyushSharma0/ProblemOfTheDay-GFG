// Link: https://practice.geeksforgeeks.org/problems/minimum-deletitions1648/1#
// Time Complexity: O(N^2)
// Space Complexity: O(N^2)

class Solution {
    static int minimumNumberOfDeletions(String S) {
        int n = S.length();
        int[][] dp = new int[n][n];

        // Initialize the dp array
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill the dp array using bottom-up approach
        for (int cl = 2; cl <= n; cl++) {
            for (int i = 0; i < n - cl + 1; i++) {
                int j = i + cl - 1;
                if (S.charAt(i) == S.charAt(j) && cl == 2) {
                    dp[i][j] = 2;
                } else if (S.charAt(i) == S.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        // The length of the longest palindromic subsequence
        int lpsLength = dp[0][n - 1];

        // The minimum number of deletions required
        int deletions = n - lpsLength;

        return deletions;
    }
}
