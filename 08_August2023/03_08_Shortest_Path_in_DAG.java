// Link: https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
// Time Complexity: O(N + M) where N is the number of vertices and M is the number of edges
// Space Complexity: O(N + M) where N is the number of vertices and M is the number of edges


import java.util.*;

class Solution {

    public int[] shortestPath(int N, int M, int[][] edges) {
        // Create an adjacency list to represent the DAG
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Populate the adjacency list with directed edges and their weights
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
        }
        
        // Initialize an array to store shortest distances from source vertex
        int[] distances = new int[N];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0; // Distance from source to itself is 0
        
        // Create a priority queue (min heap) to efficiently find the next vertex with the shortest distance
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[] { 0, 0 }); // Add source vertex to the heap
        
        // Apply Dijkstra's algorithm
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll(); // Get the vertex with the shortest distance
            int vertex = curr[0];
            int distance = curr[1];
            
            // Skip outdated entries in the heap
            if (distance > distances[vertex]) {
                continue;
            }
            
            // Traverse neighbors of the current vertex
            for (int[] neighbor : graph.get(vertex)) {
                int nextVertex = neighbor[0];
                int edgeWeight = neighbor[1];
                
                // Relaxation: Update distance if a shorter path is found
                if (distances[vertex] + edgeWeight < distances[nextVertex]) {
                    distances[nextVertex] = distances[vertex] + edgeWeight;
                    minHeap.offer(new int[] { nextVertex, distances[nextVertex] });
                }
            }
        }
        
        // Convert unreachable vertices to -1 in the distances array
        for (int i = 0; i < N; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                distances[i] = -1;
            }
        }
        
        return distances; // Return the array of shortest distances
    }
}
