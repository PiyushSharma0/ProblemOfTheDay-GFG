// Link: https://www.geeksforgeeks.org/problems/techfest-and-the-queue1044/1
// Time Complexity: O(N * log(N))
// Space Complexity: O(1)

class Solution{
     public static long sumOfPowers(long a, long b) {
        long sum = 0;

        for (long i = a; i <= b; i++) {
            sum += calculateSumOfPowers(i);
        }

        return sum;
    }

    private static long calculateSumOfPowers(long number) {
        long sum = 0;

        for (long factor = 2; factor * factor <= number; factor++) {
            int power = 0;

            while (number % factor == 0) {
                number /= factor;
                power++;
            }

            sum += power;
        }

        if (number > 1) {
            sum += 1; // If there is a remaining prime factor
        }

        return sum;
    }
}