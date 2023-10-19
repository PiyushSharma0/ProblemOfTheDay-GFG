// Link: https://practice.geeksforgeeks.org/problems/level-of-nodes-1587115620/1
// Time Complexity: O(V + E)
// Space Complexity: O(V)

import java.util.*;

class Solution {
    // Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {
        // Create an array to keep track of visited nodes.
        boolean[] visited = new boolean[V];

        // Create an array to keep track of the level of each node.
        int[] level = new int[V];

        // Create a queue for BFS traversal.
        Queue<Integer> q = new LinkedList<>();

        // Start from node 0.
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int current = q.poll();

            // Traverse the neighbors of the current node.
            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    level[neighbor] = level[current] + 1;
                    q.offer(neighbor);
                }
            }
        }

        // Check if the target node X was visited.
        if (visited[X]) {
            return level[X];  // Return the level of node X.
        } else {
            return -1;  // Node X is not reachable in the graph.
        }
    }
}
