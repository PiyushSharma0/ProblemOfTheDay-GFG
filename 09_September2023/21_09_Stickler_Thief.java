// Link: https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution
{
    // Function to find the maximum money the thief can get.
    public int FindMaxSum(int[] arr, int n)
    {
        if (n == 0)
            return 0;
        if (n == 1)
            return arr[0];

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++)
        {
            // Calculate the maximum money when including and excluding the current house.
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }

        // The final answer will be stored in dp[n-1].
        return dp[n - 1];
    }
}