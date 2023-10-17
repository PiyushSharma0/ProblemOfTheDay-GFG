// Link: https://practice.geeksforgeeks.org/problems/transitive-closure-of-a-graph/0
// Time Complexity: O(n^3)
// Space Complexity: O(n^2)

import java.util.ArrayList;

class Solution {
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int[][] graph) {
        // Create a 2D ArrayList to represent the transitive closure
        ArrayList<ArrayList<Integer>> transitive = new ArrayList<>();

        // Initialize the transitive closure matrix with values from the input graph
        for (int i = 0; i < N; i++) {
            transitive.add(new ArrayList<>());
            for (int j = 0; j < N; j++) {
                if (i == j || graph[i][j] == 1) {
                    // If i equals j or there's a direct edge from i to j, set it to 1
                    transitive.get(i).add(1);
                } else {
                    // Otherwise, set it to 0
                    transitive.get(i).add(0);
                }
            }
        }

        // Use Floyd-Warshall algorithm to update the transitive closure
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // If there is a path from i to k and from k to j, set the path from i to j to 1
                    if (transitive.get(i).get(k) == 1 && transitive.get(k).get(j) == 1) {
                        transitive.get(i).set(j, 1);
                    }
                }
            }
        }

        // Return the computed transitive closure
        return transitive;
    }
}
