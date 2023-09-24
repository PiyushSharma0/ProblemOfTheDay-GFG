// Link: https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array/
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> result = new ArrayList<>();

        // Traverse the input array
        for (int i = 0; i < n; i++) {
            int index = arr[i] % n; // Map the element to a valid index
            arr[index] += n; // Increment the value at the mapped index by n
        }

        // Traverse the modified array to find duplicates
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 2 * n) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            result.add(-1);
        }

        return result;
    }
}