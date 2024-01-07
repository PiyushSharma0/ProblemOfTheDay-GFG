// Link: https://practice.geeksforgeeks.org/problems/split-array-largest-sum/0
// Time Complexity: O(N * log(N))
// Space Complexity: O(1)

class Solution {
    static int splitArray(int[] arr, int N, int K) {
        // Initialize the search space
        int low = 0;
        int high = Integer.MAX_VALUE;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, N, K, mid)) {
                // If it's possible to split the array into K subarrays with max sum <= mid,
                // then search for smaller values in the left half of the search space
                high = mid;
            } else {
                // If it's not possible, then search for larger values in the right half
                low = mid + 1;
            }
        }

        return low;
    }

    static boolean isPossible(int[] arr, int N, int K, int mid) {
        int count = 0;
        int currentSum = 0;

        for (int i = 0; i < N; i++) {
            // If the current element is greater than mid, it's not possible
            if (arr[i] > mid) {
                return false;
            }

            // Try to add the current element to the current subarray
            currentSum += arr[i];

            // If adding the current element exceeds mid, start a new subarray
            if (currentSum > mid) {
                count++;
                currentSum = arr[i];
            }
        }

        // Check if the total number of subarrays is less than or equal to K
        return count + 1 <= K;
    }
}
