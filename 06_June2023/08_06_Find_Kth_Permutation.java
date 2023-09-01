// Link: https://practice.geeksforgeeks.org/problems/find-kth-permutation-0932/1
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public static String kthPermutation(int n, int k) {
        // Create a list to store the available digits
        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            digits.add(i);
        }

        // Create a StringBuilder to store the kth permutation sequence
        StringBuilder sb = new StringBuilder();

        // Calculate the factorial of (n-1)
        int factorial = 1;
        for (int i = 2; i <= n - 1; i++) {
            factorial *= i;
        }

        // Decrement k to align with 0-based indexing
        k--;

        // Generate the kth permutation sequence
        for (int i = n - 1; i >= 1; i--) {
            // Calculate the index of the digit to be added
            int index = k / factorial;

            // Add the digit to the StringBuilder
            sb.append(digits.get(index));

            // Remove the digit from the available digits list
            digits.remove(index);

            // Update k and factorial for the remaining digits
            k %= factorial;
            factorial /= i;
        }

        // Add the last remaining digit to the StringBuilder
        sb.append(digits.get(0));

        // Return the kth permutation sequence as a string
        return sb.toString();
    }
}
