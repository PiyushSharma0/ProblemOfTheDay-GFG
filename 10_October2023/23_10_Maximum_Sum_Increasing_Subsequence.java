// Link: https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1
// Time Complexity: O(n^2)
// Space Complexity: O(n)

class Solution
{
    public int maxSumIS(int arr[], int n)  
    {  
        int[] dp = new int[n];
        int maxSum = 0;

        // Initialize the dp array with the values from the original array
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
        }

        // Calculate the maximum increasing subsequence sum for each element
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
                    dp[i] = dp[j] + arr[i];
                }
            }
        }

        // Find the maximum sum in dp
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxSum) {
                maxSum = dp[i];
            }
        }

        return maxSum;
    }  
}
