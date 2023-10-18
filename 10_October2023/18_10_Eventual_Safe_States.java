// Link: https://practice.geeksforgeeks.org/problems/eventual-safe-states/1
// Time Complexity: O(V + E)
// Space Complexity: O(V)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        int[] color = new int[V]; // 0: unvisited, 1: visiting, 2: safe
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            if (dfs(i, adj, color))
                result.add(i);
        }
        
        Collections.sort(result);
        return result;
    }
    
    private boolean dfs(int node, List<List<Integer>> adj, int[] color) {
        if (color[node] != 0)
            return color[node] == 2;
        
        color[node] = 1; // Mark as visiting
        
        for (int neighbor : adj.get(node)) {
            if (!dfs(neighbor, adj, color))
                return false;
        }
        
        color[node] = 2; // Mark as safe
        return true;
    }
}
