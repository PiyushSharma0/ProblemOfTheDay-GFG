// Link: https://practice.geeksforgeeks.org/problems/power-of-numbers-1587115620/1
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    long mod = 1000000007;

    // Function to calculate the power of a number (a) to the exponent (n)
    long powerexpo(long a, long n) {
        long res = 1L;
        while (n > 0) {
            // If the least significant bit of n is 1
            if ((n & 1) == 1) {
                res = (res % mod * a % mod) % mod; // Multiply res with a and take modulo
                --n; // Decrement n by 1
            } else {
                a = (a % mod * a % mod) % mod; // Square a and take modulo
                n >>= 1; // Right shift n by 1 (equivalent to dividing by 2)
            }
        }
        return res; // Return the final result
    }

    // Function to calculate N raised to the power of R
    long power(int N, int R) {
        return powerexpo(N, R); // Call powerexpo with the given inputs
    }
}
