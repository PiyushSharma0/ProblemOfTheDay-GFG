// Link: https://practice.geeksforgeeks.org/problems/nth-fibonacci-number1335/1
// Time Complexity: O(n)
//  Space Complexity: O(n)

class Solution {
    static int nthFibonacci(int n) {
        if (n <= 0) return 0; // Fibonacci of 0 is 0
        if (n == 1) return 1; // Fibonacci of 1 is 1
        
        int MOD = 1000000007; // Modulo value
        
        // Create an array to store Fibonacci numbers
        int[] fib = new int[n + 1];
        
        fib[0] = 0; // Base case: Fibonacci of 0 is 0
        fib[1] = 1; // Base case: Fibonacci of 1 is 1
        
        // Calculate Fibonacci numbers using dynamic programming
        for (int i = 2; i <= n; i++) {
            // The next Fibonacci number is the sum of the last two
            fib[i] = (fib[i - 1] + fib[i - 2]) % MOD;
        }
        
        return fib[n]; // Return the nth Fibonacci number modulo 1000000007
    }
}