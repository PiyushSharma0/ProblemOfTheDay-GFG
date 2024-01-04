// Link: https://www.geeksforgeeks.org/problems/find-element-occuring-once-when-all-other-are-present-thrice/1
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    static int singleElement(int[] arr, int N) {
        int result = 0;

        // Iterate through each bit position
        for (int i = 0; i < 32; i++) {
            int count = 0;

            // Count the number of set bits at the current position for all elements
            for (int j = 0; j < N; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    count++;
                }
            }

            // If the count is not a multiple of 3, set the bit in the result
            if (count % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }
}
