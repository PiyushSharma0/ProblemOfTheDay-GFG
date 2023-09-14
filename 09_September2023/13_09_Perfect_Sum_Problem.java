// Link: https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/
// Time Complexity: O(n * sum)
// Space Complexity: O(n * sum)

class Solution {
    static int MOD = 1000000007;

    public int perfectSum(int arr[], int n, int sum) {
        // Initialize a DP array to store the count of subsets
        int[][] dp = new int[n + 1][sum + 1];

        // Initialize dp[0][0] to 1 since there's one way to get a sum of 0 with an empty subset
        dp[0][0] = 1;

        // Populate the DP array
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j]; // Exclude the current element

                // Include the current element if it doesn't exceed the current sum
                if (j >= arr[i - 1]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - arr[i - 1]]) % MOD;
                }
            }
        }

        return dp[n][sum];
    }
}