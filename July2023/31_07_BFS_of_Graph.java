// Link: https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity: O(V) where V is the number of vertices in the graph.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        if (V == 0) {
            return result; // Return an empty list if there are no nodes.
        }

        // Create a boolean array to keep track of visited nodes.
        boolean[] visited = new boolean[V];

        // Create a queue for BFS traversal.
        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from node 0.
        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            // Enqueue all unvisited neighbors of the current node.
            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return result;
    }
}