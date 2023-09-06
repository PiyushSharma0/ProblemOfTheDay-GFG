// Link: https://practice.geeksforgeeks.org/problems/mother-vertex/1
// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph.

import java.util.ArrayList;

class Solution
{
    // Helper function to perform DFS and mark visited vertices
    private void dfs(ArrayList<ArrayList<Integer>> adj, int v, boolean[] visited)
    {
        visited[v] = true;

        for (int neighbor : adj.get(v))
        {
            if (!visited[neighbor])
                dfs(adj, neighbor, visited);
        }
    }

    // Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        int lastVisited = -1; // Initialize with -1, no vertex visited yet

        // Perform DFS from all vertices to check reachability
        for (int i = 0; i < V; i++)
        {
            if (!visited[i])
            {
                dfs(adj, i, visited);
                lastVisited = i;
            }
        }

        // Reset visited array for the final check
        visited = new boolean[V];
        dfs(adj, lastVisited, visited);

        // Check if the lastVisited vertex is a mother vertex
        for (int i = 0; i < V; i++)
        {
            if (!visited[i])
                return -1; // No mother vertex found
        }

        return lastVisited; // The lastVisited vertex is a mother vertex
    }
}
