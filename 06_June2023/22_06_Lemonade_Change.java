// Link: https://practice.geeksforgeeks.org/problems/lemonade-change/1
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
        // Initialize variables to keep track of the number of $5, $10, and $20 bills
        int fiveCount = 0;
        int tenCount = 0;
        int twentyCount = 0;

        // Iterate over each customer's bill
        for (int bill : bills) {
            // If the customer gives a $5 bill
            if (bill == 5) {
                fiveCount++; // Increment the number of $5 bills we have
            }
            // If the customer gives a $10 bill
            else if (bill == 10) {
                if (fiveCount > 0) { // If we have a $5 bill to provide change
                    fiveCount--; // Decrement the number of $5 bills
                    tenCount++; // Increment the number of $10 bills
                } else {
                    return false; // We can't provide change, return false
                }
            }
            // If the customer gives a $20 bill
            else if (bill == 20) {
                if (tenCount > 0 && fiveCount > 0) {
                    // First, try to provide change using a $10 bill and a $5 bill
                    tenCount--; // Decrement the number of $10 bills
                    fiveCount--; // Decrement the number of $5 bills
                } else if (fiveCount >= 3) {
                    // If we can't provide change using a $10 bill and a $5 bill, try using three $5 bills
                    fiveCount -= 3; // Decrement the number of $5 bills by 3
                } else {
                    return false; // We can't provide change, return false
                }
                twentyCount++; // Increment the number of $20 bills
            }
        }

        return true; // We successfully provided change to all customers, return true
    }
}