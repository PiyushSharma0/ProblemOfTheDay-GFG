// Link: https://practice.geeksforgeeks.org/problems/count-number-of-hops-1587115620/1
// Time Complexity: O(N) (N is the number of steps)
// Space Complexity: O(N) (N is the number of steps)

class Solution
{
    static long countWays(int n)
    {
        // Define a modulo constant
        final long MOD = 1000000007;
        
        // Create an array to store the number of ways to reach each step
        long[] dp = new long[n + 1];
        
        // Initialize base cases
        dp[0] = 1;  // There's one way to be at step 0 (starting point)
        
        // Fill the dp array
        for (int i = 1; i <= n; i++)
        {
            // Try jumping 1, 2, and 3 steps
            for (int j = 1; j <= 3; j++)
            {
                if (i - j >= 0)
                {
                    dp[i] = (dp[i] + dp[i - j]) % MOD;
                }
            }
        }
        
        // The number of ways to reach the Nth step is stored in dp[n]
        return dp[n];
    }
}