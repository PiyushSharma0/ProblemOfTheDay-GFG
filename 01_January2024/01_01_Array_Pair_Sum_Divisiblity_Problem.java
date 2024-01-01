// Link: https://www.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1
// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canPair(int[] nums, int k) {
        if (nums.length % 2 != 0) {
            // If the array length is odd, pairing is not possible
            return false;
        }

        // Create a HashMap to store the remainders
        Map<Integer, Integer> remainderMap = new HashMap<>();

        // Populate the remainderMap
        for (int num : nums) {
            int remainder = (num % k + k) % k; // Handle negative remainders
            remainderMap.put(remainder, remainderMap.getOrDefault(remainder, 0) + 1);
        }

        // Check if each remainder can be paired with another to sum up to a multiple of k
        for (int num : nums) {
            int remainder = (num % k + k) % k; // Handle negative remainders

            if (remainder != 0) {
                // If remainder is not 0, check if there is a matching pair
                int complement = (k - remainder) % k;

                if (remainderMap.getOrDefault(complement, 0) <= 0) {
                    // If the complement is not present or already used, pairing is not possible
                    return false;
                }

                // Reduce the count of the complement in the remainderMap
                remainderMap.put(complement, remainderMap.get(complement) - 1);
            } else {
                // If remainder is 0, check if there are an even number of such elements
                if (remainderMap.getOrDefault(0, 0) % 2 != 0) {
                    return false;
                }
            }
        }

        // All elements are successfully paired
        return true;
    }
}
