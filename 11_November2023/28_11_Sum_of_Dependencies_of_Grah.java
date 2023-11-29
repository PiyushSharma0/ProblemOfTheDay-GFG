// Link: https://practice.geeksforgeeks.org/problems/sum-of-dependencies-in-a-graph/0
// Time Complexity: O(V)
// Space Complexity: O(1)

import java.util.ArrayList;

class Solution {
    int sumOfDependencies(ArrayList<ArrayList<Integer>> adj, int V) {
        int sum = 0;

        // Iterate through each node
        for (int i = 0; i < V; i++) {
            // Count the number of dependencies for the current node
            int dependencies = adj.get(i).size();
            sum += dependencies;
        }

        return sum;
    }
};