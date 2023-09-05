// Link: https://practice.geeksforgeeks.org/problems/print-adjacency-list-1587115620/1
// Time Complexity: O(E) where E is the number of edges in the graph.
// Space Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        // Initialize the adjacency list with V empty lists.
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }

        // Use a HashMap to store the adjacency lists for each node.
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        for (int i = 0; i < V; i++) {
            adjacencyMap.put(i, adjacencyList.get(i));
        }

        // Add edges to the adjacency list.
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];

            // Add the destination node to the source node's adjacency list.
            adjacencyMap.get(src).add(dest);

            // Since the graph is undirected, we also need to add the source node to the destination node's adjacency list.
            adjacencyMap.get(dest).add(src);
        }

        return adjacencyList;
    }
}