// Link: https://practice.geeksforgeeks.org/problems/coin-change2448/1
// Time Complexity: O(N * S) where N is the number of coins and S is the required sum
// Space Complexity: O(S)

class Solution {
    public long count(int coins[], int N, int sum) {
        // dp[i] represents the number of ways to make the sum 'i'
        long[] dp = new long[sum + 1];
        
        // Base case: There's one way to make a sum of 0, which is by not selecting any coins.
        dp[0] = 1;
        
        // Loop through each coin denomination
        for (int coin : coins) {
            // For each coin, update dp[i] for all values of i that can be made using this coin
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        // The final answer is stored in dp[sum]
        return dp[sum];
    }
}
