// Link: https://www.geeksforgeeks.org/fractional-knapsack-problem/
// Time Complexity: O(n log n) (Since we are sorting the items based on value-to-weight ratio)
// Space Complexity: O(1) (Since we are not using any extra space)


class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) {
        // Sorting items based on value-to-weight ratio in descending order.
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                double ratio1 = (double) item1.value / item1.weight;
                double ratio2 = (double) item2.value / item2.weight;
                return Double.compare(ratio2, ratio1); // Note: Reversed order
            }
        });

        double totalValue = 0.0; // To store the maximum total value in the knapsack.

        for (int i = 0; i < n; ++i) {
            if (W == 0) {
                break; // Knapsack is full.
            }

            if (arr[i].weight <= W) {
                // If the entire item can be added to the knapsack, add it.
                totalValue += arr[i].value;
                W -= arr[i].weight;
            } else {
                // If only a fraction of the item can be added, add the fraction.
                totalValue += ((double) arr[i].value / arr[i].weight) * W;
                W = 0; // Knapsack is full.
            }
        }

        return totalValue;
    }
}