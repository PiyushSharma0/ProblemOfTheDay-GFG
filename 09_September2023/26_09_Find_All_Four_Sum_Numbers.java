// Link: https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/
// Time Complexity: O(n^3)
// Space Complexity: O(1)

import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Check if the input array is null or has less than 4 elements
        if (arr == null || arr.length < 4) {
            return result; // Not enough elements for a quadruplet
        }

        // Sort the input array in ascending order
        Arrays.sort(arr);

        int n = arr.length;

        for (int q1 = 0; q1 < n - 3; ++q1) {
            // Skip duplicate values for the first element of the quadruplet
            if (q1 > 0 && arr[q1] == arr[q1 - 1])
                continue;

            for (int q2 = q1 + 1; q2 < n - 2; ++q2) {
                // Skip duplicate values for the second element of the quadruplet
                if (q2 > q1 + 1 && arr[q2] == arr[q2 - 1])
                    continue;

                int q3 = q2 + 1;
                int q4 = n - 1;

                while (q3 < q4) {
                    int sum = arr[q1] + arr[q2] + arr[q3] + arr[q4];

                    if (sum == k) {
                        // Found a quadruplet that sums to the target value
                        ArrayList<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(arr[q1]);
                        quadruplet.add(arr[q2]);
                        quadruplet.add(arr[q3]);
                        quadruplet.add(arr[q4]);
                        result.add(quadruplet);

                        // Move q3 and q4 to look for other solutions
                        q3++;
                        q4--;

                        // Skip duplicate values for the third and fourth elements of the quadruplet
                        while (q3 < q4 && arr[q3] == arr[q3 - 1])
                            q3++;
                        while (q3 < q4 && arr[q4] == arr[q4 + 1])
                            q4--;
                    } else if (sum < k) {
                        // Increment q3 to increase the sum
                        q3++;
                    } else {
                        // Decrement q4 to decrease the sum
                        q4--;
                    }
                }
            }
        }

        return result;
    }
}