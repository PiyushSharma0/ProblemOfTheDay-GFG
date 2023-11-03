// Link: https://practice.geeksforgeeks.org/problems/pythagorean-triplet3018/1
// Time Complexity: O(n^2)
// Space Complexity: O(n)

import java.util.HashSet;

class Solution {
    boolean checkTriplet(int[] arr, int n) {
        // Create a set to store the square of each element in the array
        HashSet<Integer> set = new HashSet<>();

        // Square each element in the array and store it in the set
        for (int i = 0; i < n; i++) {
            set.add(arr[i] * arr[i]);
        }

        // Iterate through the array and for each pair of elements (a, b), check if a^2 + b^2 is in the set
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sumOfSquares = arr[i] * arr[i] + arr[j] * arr[j];
                if (set.contains(sumOfSquares)) {
                    return true;
                }
            }
        }

        return false;
    }
}
