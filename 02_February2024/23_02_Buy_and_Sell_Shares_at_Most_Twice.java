// Link: https://www.geeksforgeeks.org/problems/buy-and-sell-a-share-at-most-twice/1
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public static int maxProfit(int n, int[] price) {
        if (n <= 1) {
            return 0; // No profit if there are less than 2 prices
        }

        // Arrays to store the maximum profit at each step
        int[] profitBefore = new int[n];
        int[] profitAfter = new int[n];

        // Initialize the first buy and sell for the first day
        int minPrice = price[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, price[i]);
            profitBefore[i] = Math.max(profitBefore[i - 1], price[i] - minPrice);
        }

        // Initialize the second buy and sell for the last day
        int maxPrice = price[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, price[i]);
            profitAfter[i] = Math.max(profitAfter[i + 1], maxPrice - price[i]);
        }

        // Calculate the maximum profit by combining the two transactions
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, profitBefore[i] + (i + 1 < n ? profitAfter[i + 1] : 0));
        }

        return maxProfit;
    }
}