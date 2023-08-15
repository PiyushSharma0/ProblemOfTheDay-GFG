// Link: https://practice.geeksforgeeks.org/problems/flip-bits0240/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {

    public static int maxOnes(int a[], int n) {
        int zero = 0; // Count of consecutive zeros encountered
        int one = 0; // Count of ones encountered
        int maxFlips = 0; // Maximum number of zeros that can be flipped

        for (int i = 0; i < n; ++i) {
            if (a[i] == 0)
                zero++; // Increment zero count for consecutive zeros
            else {
                zero--;
                one++; // Increment one count for ones
            }

            if (zero < 0)
                zero = 0; // Reset zero count if it becomes negative

            maxFlips = Math.max(zero, maxFlips); // Update maxFlips if zero count is greater
        }
        
        return maxFlips + one; // Return the total maximum ones after possible flips
    }
}
