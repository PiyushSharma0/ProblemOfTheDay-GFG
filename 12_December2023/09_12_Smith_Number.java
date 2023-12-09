// Link: https://practice.geeksforgeeks.org/problems/smith-number/0
// Time Complexity: O(logN + sqrt(N) The prime factorization has a time complexity of O(sqrt(n)), and calculating the sum of digits also takes O(log(n)) time
// Space Complexity: O(1)

class Solution {
    // Function to check if a number is prime
    static boolean isPrime(int n) {
        if (n == 1)
            return false;

        for (int i = 2; i <= Math.sqrt(n); ++i)
            if (n % i == 0)
                return false;

        return true;
    }

    // Function to calculate the sum of digits of a number
    static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    // Function to calculate the sum of digits of prime factors of a number
    static int sumOfPrimeFactor(int n) {
        int f = 1;
        int sum = 0;
        while (n > 1) {
            ++f;
            if (!isPrime(f))
                continue;

            while (n % f == 0) {
                sum += sumOfDigits(f);
                n /= f;
            }
        }
        return sum;
    }

    // Function to check if a number is a Smith number
    static int smithNum(int n) {
        // If the number is prime, it cannot be a Smith number
        if (isPrime(n))
            return 0;

        // Check if the sum of digits of prime factors is equal to the sum of digits of the number
        return (sumOfPrimeFactor(n) == sumOfDigits(n)? 1:0);
    }
};