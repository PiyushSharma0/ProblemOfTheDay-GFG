// Link: https://practice.geeksforgeeks.org/problems/reverse-coding2452/1
// Time Complexity: O(1)
// Space Complexity: O(1)

class Solution {
    public int sumOfNaturals(int n) {
        // Compute the sum of natural numbers using the formula n * (n + 1) / 2
        long sum = ((long) n * (n + 1)) / 2;

        // Take the modulo of the sum with 1000000007 to ensure the result remains within the specified range
        return (int) (sum % 1000000007);
    }
}
