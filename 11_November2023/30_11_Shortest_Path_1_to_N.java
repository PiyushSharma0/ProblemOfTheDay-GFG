// Link: https://practice.geeksforgeeks.org/problems/shortest-path-from-1-to-n0156/1#
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    public int minStep(int n) {
        // Create an array to store the minimum number of steps to reach each vertex
        int[] dp = new int[n + 1];

        // Base case: It takes 0 steps to reach vertex 1
        dp[1] = 0;

        // Fill the dp array from vertex 2 to vertex n
        for (int i = 2; i <= n; i++) {
            // Initialize the minimum steps to reach the current vertex
            dp[i] = dp[i - 1] + 1;

            // Check if reaching the current vertex through a multiple of 3 is better
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        // The result is stored in dp[n]
        return dp[n];
    }
}
