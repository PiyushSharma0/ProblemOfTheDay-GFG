// Link: https://practice.geeksforgeeks.org/problems/find-optimum-operation4504/1#
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    public int minOperation(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE; // Initialize the value to a maximum value
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // Double operation
            }
            dp[i] = Math.min(dp[i], dp[i - 1] + 1); // Add one operation
        }

        return dp[n];
    }
}