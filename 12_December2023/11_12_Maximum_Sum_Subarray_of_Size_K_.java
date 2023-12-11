// Link: https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        long maxSum = 0;
        long currentSum = 0;

        // Calculate the sum of the first K elements
        for (int i = 0; i < K; i++) {
            currentSum += Arr.get(i);
        }

        maxSum = currentSum;

        // Use a sliding window to find the maximum sum
        for (int i = K; i < N; i++) {
            // Add the current element to the window
            currentSum += Arr.get(i);
            
            // Remove the first element of the window
            currentSum -= Arr.get(i - K);

            // Update the maximum sum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}