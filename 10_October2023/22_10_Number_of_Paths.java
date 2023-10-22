// Link: https://practice.geeksforgeeks.org/problems/number-of-paths0926/1/
// Time Complexity: O(M)
//  Auxiliary Space: O(1)

class Solution {
    final int mod = 1000000007;

    // Recursive function to calculate the modular inverse
    long modInv(long a, long b) {
        return a > 1 ? b - (modInv(b % a, a) * b / a) : 1;
    }

    long numberOfPaths(int m, int n) {
        long out = 1;

        for (int i = 0; i < m - 1; i++) {
            // Calculate the modular inverse of (i + 1)
            long inverse = modInv(i + 1, mod);
            
            // Update the result (out) with the product of (i + n) modulo mod
            out = (out * (i + n)) % mod;
            
            // Update the result (out) with the product of the modular inverse modulo mod
            out = (out * inverse) % mod;
        }

        return out;
    }
}