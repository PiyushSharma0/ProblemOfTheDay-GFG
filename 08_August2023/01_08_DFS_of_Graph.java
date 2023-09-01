// Link: https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity: O(V) where V is the number of vertices in the graph.

import java.util.*;

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        if (V == 0) {
            return result; // Return an empty list if there are no nodes.
        }

        // Create a boolean array to keep track of visited nodes.
        boolean[] visited = new boolean[V];

        // Start DFS from node 0.
        dfs(0, adj, visited, result);

        return result;
    }

    // Recursive DFS function
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        // Mark the current node as visited and add it to the result list.
        visited[node] = true;
        result.add(node);

        // Traverse all unvisited neighbors of the current node and call DFS on them.
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, result);
            }
        }
    }
}
