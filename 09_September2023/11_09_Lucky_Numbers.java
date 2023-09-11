// Link: https://practice.geeksforgeeks.org/problems/lucky-numbers2911/
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    // Function to check if a number is lucky
    public static boolean isLucky(int n) {
        int counter = 2; // Initialize the counter to 2 as per the lucky number rule
        
        // Iterate while the counter is less than or equal to the input number
        while (counter <= n) {
            if (n % counter == 0)
                return false; // If n is divisible by counter, it's not a lucky number

            n -= n / counter; // Reduce n by the count of numbers to delete
            counter++; // Increment the counter for the next iteration
        }

        return true; // If the loop completes, n is a lucky number
    }
}
