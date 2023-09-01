// Link: https://practice.geeksforgeeks.org/problems/rod-cutting0840/
// Time Complexity: O(n^2)
// Space Complexity: O(n)

class Solution {
    public int cutRod(int price[], int n) {
        // Create an array to store the maximum obtainable values for each rod length
        int[] dp = new int[n + 1];
        dp[0] = 0; // Initialize the value for rod length 0 as 0

        // Iterate over all possible rod lengths from 1 to n
        for (int i = 1; i <= n; i++) {
            int maxVal = Integer.MIN_VALUE; // Initialize the maximum value as the smallest possible value

            // Iterate over all possible cuts for the current rod length
            for (int j = 0; j < i; j++) {
                // Calculate the maximum value obtainable by considering the current cut
                // and the maximum value obtainable for the remaining rod length
                maxVal = Math.max(maxVal, price[j] + dp[i - j - 1]);
            }

            // Store the maximum value obtainable for the current rod length
            dp[i] = maxVal;
        }

        // Return the maximum value obtainable for the entire rod
        return dp[n];
    }
}
