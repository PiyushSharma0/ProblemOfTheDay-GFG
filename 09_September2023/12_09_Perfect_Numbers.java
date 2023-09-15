// Link: https://practice.geeksforgeeks.org/problems/perfect-numbers
// Time Complexity: O(sqrt(N))
// Space Complexity: O(1)

class Solution {
    static int isPerfectNumber(long N) {
        if (N <= 1) {
            return 0; // 0 and 1 are not perfect numbers
        }
        
        long sum = 1; // Initialize sum with 1 because 1 is always a factor of any number
        
        // Find all factors of N and add them to the sum
        for (long i = 2; i * i <= N; i++) {
            if (N % i == 0) {
                sum += i;
                if (i != N / i) {
                    sum += N / i;
                }
            }
        }
        
        // Check if the sum of factors equals N
        if (sum == N) {
            return 1; // N is a perfect number
        } else {
            return 0; // N is not a perfect number
        }
    }
}
