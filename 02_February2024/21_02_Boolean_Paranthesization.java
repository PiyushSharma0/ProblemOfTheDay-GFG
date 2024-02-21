// Link: https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1
// Time Complexity: O(n^3)
// Space Complexity: O(n^2)

class Solution {
    static int countWays(int n, String s) {
        // Modulo value
        int MOD = 1003;

        // dp[i][j][0] represents the number of ways to parenthesize
        // the subexpression s[i..j] to evaluate to false.
        // dp[i][j][1] represents the number of ways to parenthesize
        // the subexpression s[i..j] to evaluate to true.
        int[][][] dp = new int[n][n][2];

        // Initialize the base cases
        for (int i = 0; i < n; i += 2) {
            if (s.charAt(i) == 'T') {
                dp[i][i][1] = 1;
            } else {
                dp[i][i][0] = 1;
            }
        }

        // Build the table using bottom-up dynamic programming
        for (int len = 3; len <= n; len += 2) {
            for (int i = 0; i + len - 1 < n; i += 2) {
                int j = i + len - 1;

                for (int k = i + 1; k < j; k += 2) {
                    char operator = s.charAt(k);

                    if (operator == '&') {
                        dp[i][j][1] = (dp[i][j][1] + dp[i][k - 1][1] * dp[k + 1][j][1]) % MOD;
                        dp[i][j][0] = (dp[i][j][0] + dp[i][k - 1][0] * dp[k + 1][j][1] + dp[i][k - 1][1] * dp[k + 1][j][0] + dp[i][k - 1][0] * dp[k + 1][j][0]) % MOD;
                    } else if (operator == '|') {
                        dp[i][j][1] = (dp[i][j][1] + dp[i][k - 1][1] * dp[k + 1][j][1] + dp[i][k - 1][1] * dp[k + 1][j][0] + dp[i][k - 1][0] * dp[k + 1][j][1]) % MOD;
                        dp[i][j][0] = (dp[i][j][0] + dp[i][k - 1][0] * dp[k + 1][j][0]) % MOD;
                    } else if (operator == '^') {
                        dp[i][j][1] = (dp[i][j][1] + dp[i][k - 1][0] * dp[k + 1][j][1] + dp[i][k - 1][1] * dp[k + 1][j][0]) % MOD;
                        dp[i][j][0] = (dp[i][j][0] + dp[i][k - 1][1] * dp[k + 1][j][1] + dp[i][k - 1][0] * dp[k + 1][j][0]) % MOD;
                    }
                }
            }
        }

        return dp[0][n - 1][1];
    }
}
