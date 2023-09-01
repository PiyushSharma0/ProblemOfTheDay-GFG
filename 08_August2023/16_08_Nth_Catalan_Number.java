// Link: https://practice.geeksforgeeks.org/problems/nth-catalan-number0817/1
// Time Complexity: O(n^2)
// Space Complexity: O(n)

class Solution {
    public static int findCatalan(int n) {
        int MOD = (int) 1e9 + 7;
        
        // Create an array to store the Catalan numbers
        int[] catalan = new int[n + 1];
        
        // Base case: C(0) = 1
        catalan[0] = 1;
        
        // Calculate Catalan numbers using dynamic programming
        for (int i = 1; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] = (catalan[i] + (int) ((long) catalan[j] * catalan[i - j - 1] % MOD)) % MOD;
            }
        }
        
        return catalan[n];
    }
}