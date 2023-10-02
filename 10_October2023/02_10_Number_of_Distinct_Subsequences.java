// Link: https://practice.geeksforgeeks.org/problems/number-of-distinct-subsequences0909/1
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.Arrays;

class Solution {
    int mod = 1000000007;
    
    public int distinctSubsequences(String s) {
        int n = s.length();
        
        // Initialize an array to store the last position of each character (a-z) in the string.
        int[] last = new int[26];
        Arrays.fill(last, -1); // Initialize all entries to -1.
        
        // Initialize an array to store the number of distinct subsequences ending at each position in the string.
        long[] dp = new long[n + 1];
        dp[0] = 1; // An empty string is a valid subsequence.
        
        for (int i = 1; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2) % mod; // Double the previous count of subsequences.
            int lastOccur = last[s.charAt(i - 1) - 'a']; // Find the last position of the current character.
            
            if (lastOccur != -1) {
                // Subtract the count of subsequences ending at the last occurrence of the current character.
                dp[i] -= dp[lastOccur];
                
                if (dp[i] < 0) {
                    dp[i] += mod; // Ensure that the result is non-negative.
                }
            }
            
            dp[i] %= mod; // Take modulo to avoid overflow.
            last[s.charAt(i - 1) - 'a'] = i - 1; // Update the last position of the current character.
        }
        
        return (int) dp[n]; // Return the final count of distinct subsequences.
    }
}