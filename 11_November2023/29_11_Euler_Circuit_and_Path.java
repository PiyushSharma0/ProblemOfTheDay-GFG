// Link: https://practice.geeksforgeeks.org/problems/euler-circuit-and-path/1#
// Time Complexity: O(V)
// Space Complexity: O(V)

import java.util.List;

class Solution {
    // Function to check if the graph is Eulerian or not.
    public int isEulerCircuit(int V, List<Integer>[] adj) {
        // Initialize counters for even and odd degrees of vertices
        int even = 0, odd = 0;

        // Loop through each vertex in the graph
        for (int i = 0; i < V; i++) {
            // Check if the degree of the current vertex is odd
            if (adj[i].size() % 2 == 1) {
                odd++; // Increment the odd degree counter
            } else {
                even++; // Increment the even degree counter
            }
        }

        // If the graph has no edges, it is Eulerian (Trivial case)
        return even == V ? 2 : (odd > 0 && odd == 2) ? 1 : 0;
    }
}