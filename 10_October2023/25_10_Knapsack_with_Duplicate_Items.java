// Link: https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1#
// Time Complexity: O(N*W)
// Space Complexity: O(W)

class Solution {
    static int knapSack(int N, int W, int val[], int wt[]) {
        int[] dp = new int[W + 1]; // Initialize a 1D DP array to store maximum values for each weight

        for (int w = 0; w <= W; w++) {
            for (int i = 0; i < N; i++) {
                if (wt[i] <= w) {
                    dp[w] = Math.max(dp[w], dp[w - wt[i]] + val[i]);
                }
            }
        }

        return dp[W]; // Maximum profit for weight W is stored in dp[W]
    }
}
