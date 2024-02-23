// Link: https://practice.geeksforgeeks.org/problems/maximum-sum-problem2211/1
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    // Map to store already computed results to avoid recomputation
    private Map<Integer, Integer> memo = new HashMap<>();

    public int maxSum(int n) {
        if (n <= 1) {
            return n; // Base case: if n is 0 or 1, return itself
        }

        // Check if the result for n is already computed
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Calculate the maximum sum by dividing n into three parts
        int maxSum = Math.max(n, maxSum(n / 2) + maxSum(n / 3) + maxSum(n / 4));

        // Store the result in the memo map
        memo.put(n, maxSum);

        return maxSum;
    }
}
