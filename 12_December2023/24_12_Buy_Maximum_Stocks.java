// Link: https://www.geeksforgeeks.org/buy-maximum-stocks-stocks-can-bought-th-day/
// Time Complexity: O(NlogN)
// Space Complexity: O(N)

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
    public int buyMaximumProducts(int n, int k, int[] price) {
        // Create a list of pairs to store the prices and corresponding day
        List<Pair<Integer, Integer>> pricesWithDay = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            pricesWithDay.add(new Pair<>(price[i], i + 1));
        }

        // Sort the list based on prices
        pricesWithDay.sort(Comparator.comparingInt(Pair::getKey));

        int maxStocks = 0;

        for (Pair<Integer, Integer> pair : pricesWithDay) {
            int priceOfDay = pair.getKey();
            int day = pair.getValue();

            // Calculate the maximum number of stocks that can be bought on the current day
            int stocks = Math.min(k / priceOfDay, day);

            // Update remaining money
            k -= stocks * priceOfDay;

            // Update the total number of stocks bought
            maxStocks += stocks;
        }

        return maxStocks;
    }
}