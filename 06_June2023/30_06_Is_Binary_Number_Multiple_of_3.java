// Link: https://practice.geeksforgeeks.org/problems/is-binary-number-multiple-of-3/0
// Time Complexity: O(n) where n is the length of the binary string
// Space Complexity: O(1)

class Solution {
    int isDivisible(String s) {
        int evenSum = 0;
        int oddSum = 0;

        // Iterate through the binary string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int bit = Character.getNumericValue(s.charAt(i));

            // If the index is even, add the bit value to evenSum
            if (i % 2 == 0) {
                evenSum += bit;
            }
            // If the index is odd, add the bit value to oddSum
            else {
                oddSum += bit;
            }
        }

        // Calculate the absolute difference between evenSum and oddSum
        int diff = Math.abs(evenSum - oddSum);

        // Check if the difference is divisible by 3
        // If it is, return 1 (divisible), otherwise return 0 (not divisible)
        return (diff % 3 == 0) ? 1 : 0;
    }
}
