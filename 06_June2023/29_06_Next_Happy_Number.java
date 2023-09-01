// Link: https://practice.geeksforgeeks.org/problems/next-happy-number4538/1
// Time Complexity: O(k * log(num)) where k is the number of happy numbers less than num
// Space Complexity: O(1)

class Solution {

    // Method to find the next happy number greater than N
    static int nextHappy(int N) {
        int num = N + 1; // Start checking from the next number
        while (true) {
            if (isHappy(num)) { // Check if the number is happy
                return num; // If it is happy, return the number
            }
            num++; // Increment the number and continue checking
        }
    }

    // Method to check if a number is happy
    static boolean isHappy(int num) {
        int sum = 0;
        while (num > 0) {
            int rem = num % 10; // Get the last digit of the number
            sum += rem * rem; // Add the square of the digit to the sum
            num = num / 10; // Remove the last digit from the number
        }
        if (sum == 1) { // If the sum is 1, the number is happy
            return true;
        } else if (sum == 4) { // If the sum is 4, the number is not happy
            return false;
        } else { // If the sum is neither 1 nor 4, continue checking with the new sum
            return isHappy(sum);
        }
    }
}
