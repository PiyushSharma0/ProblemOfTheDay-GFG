// Link: https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1#
// Time Complexity: O(n^3)
// Space Complexity: O(n^2)

import java.util.Arrays;

class Solution {
    // Function to check if the substring s[i:j] is a palindrome
    boolean isPalin(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    
    // Function to calculate the minimum cuts needed for palindrome partitioning
    int check(int i, int j, String s, int[][] dp) {
        if (i >= j)
            return 0;
        
        if (dp[i][j] != -1)
            return dp[i][j];
        
        if (isPalin(i, j, s))
            return dp[i][j] = 0;
        
        int out = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            if (isPalin(i, k, s)) {
                out = Math.min(out, 1 + check(k + 1, j, s, dp));
            }
        }
        return dp[i][j] = out;
    }
    
    // Main function to find the minimum cuts for palindrome partitioning
    int palindromicPartition(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        check(0, n - 1, str, dp);
        return check(0, n - 1, str, dp);
    }
}
