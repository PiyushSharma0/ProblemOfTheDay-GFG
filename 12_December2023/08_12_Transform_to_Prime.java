// Link: https://practice.geeksforgeeks.org/problems/transform-to-prime/0
// Time Complexity: O(NlogN)
// Space Complexity: O(1)

class Solution {
    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Function to find the minimum non-negative number to make the sum prime
    public int minNumber(int arr[], int N) {
        int sum = Arrays.stream(arr).sum();

        // If the sum is already prime, no need to add any number
        if (isPrime(sum)) {
            return 0;
        }

        // Find the nearest prime greater than the sum
        int diff = 0;
        while (!isPrime(sum + diff)) {
            diff++;
        }

        return diff;
    }
}