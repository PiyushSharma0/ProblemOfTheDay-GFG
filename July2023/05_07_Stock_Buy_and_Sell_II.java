// Link: https://practice.geeksforgeeks.org/problems/stock-buy-and-sell2615/1
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    public static int stockBuyAndSell(int n, int[] prices) {
        int profit = 0;
        int buy = 0;
        int sell = 0;
        
        for (int i = 1; i < n; i++) {
            // If the current price is less than the previous price
            if (prices[i] < prices[i - 1]) {
                // Sell the stock at the previous price
                sell = i - 1;
                
                // Add the profit to the total profit
                profit += prices[sell] - prices[buy];
                
                // Buy the stock at the current price
                buy = i;
            }
        }
        
        // Sell the stock at the last price
        sell = n - 1;
        
        // Add the profit to the total profit
        profit += prices[sell] - prices[buy];
        
        return profit;
    }
}