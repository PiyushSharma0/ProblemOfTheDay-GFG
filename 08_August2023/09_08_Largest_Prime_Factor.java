// Link: https://practice.geeksforgeeks.org/problems/largest-prime-factor2601/1
// Time Complexity: O(sqrt(N))
// Space Complexity: O(1)

class Solution {
    static long largestPrimeFactor(int N) {
        long largestPrime = -1; // Initialize the largest prime factor
        
        // Divide N by 2 until it becomes odd
        while (N % 2 == 0) {
            largestPrime = 2;
            N /= 2;
        }
        
        // Now, we only need to consider odd numbers
        for (int i = 3; i <= Math.sqrt(N); i += 2) {
            while (N % i == 0) {
                largestPrime = i;
                N /= i;
            }
        }
        
        // If N is still greater than 2, then it is the largest prime factor
        if (N > 2) {
            largestPrime = N;
        }
        
        return largestPrime;
    }
}
