// Link: https://practice.geeksforgeeks.org/problems/frequency-of-array-elements-1587115620/1/?track=Java-Collections-Arrays&batchId=318#
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    public static void frequencyCount(int arr[], int N, int P) {
        // Calculate an offset value that is one more than the maximum possible value (P).
        int offset = P + 1;

        // Step 1: Encode frequencies in the array.
        for (int i : arr) {
            // Calculate the position to update in the array based on the current value.
            // Subtract 1 to make it 0-based index and take modulo with offset to ensure it's within bounds.
            int val = (i - 1) % offset;
            
            // Check if the calculated position is within the range of 0 to N-1.
            if (val < N) {
                // Update the value at the calculated position by adding the offset.
                // This encodes the frequency of the element in the array.
                arr[val] += offset;
            }
        }

        // Step 2: Decode the frequencies and store them in the array.
        for (int i = 0; i < N; ++i) {
            // Divide the encoded value by the offset to obtain the frequency.
            arr[i] /= offset;
        }
    }
}