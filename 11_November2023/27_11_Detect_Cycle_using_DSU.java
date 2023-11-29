// Link: https://www.geeksforgeeks.org/problems/detect-cycle-using-dsu/1
// Time Complexity: O(V + E)
// Space Complexity: O(V)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class DSUGraphCycleDetection {

    // Data structures for DSU
    private List<Integer> dsu;
    private boolean[] vis;
    private List<Set<Integer>> g;

    // Find operation in DSU
    private int findDSU(int p) {
        if (dsu.get(p) < 0)
            return p;
        return dsu.set(p, findDSU(dsu.get(p)));
    }

    // Merge operation in DSU
    private void merge(int x, int y) {
        if (dsu.get(x) > dsu.get(y))
            swap(x, y);

        dsu.set(x, dsu.get(x) + dsu.get(y));
        dsu.set(y, x);
    }

    // Utility function to swap values
    private void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }

    // DFS traversal to detect cycles in the graph
    private boolean dfs(int node, int par) {
        boolean isCycle = false;
        vis[node] = true;

        for (int child : g.get(node)) {
            if (child != par) {
                int x = findDSU(node);
                int y = findDSU(child);

                // If both nodes belong to the same set in DSU, a cycle is detected
                if (x == y)
                    return true;

                // Merge the sets of the two nodes
                merge(x, y);
                isCycle = isCycle || dfs(child, node);
            }
        }

        return isCycle;
    }

    // Main function to detect cycles in an undirected graph
    public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Initialize DSU, visited array, and adjacency list
        dsu = new ArrayList<>(V);
        vis = new boolean[V];
        g = new ArrayList<>(V);

        // Initialize DSU with all nodes in their own sets
        for (int i = 0; i < V; i++) {
            dsu.add(-1);
            g.add(new HashSet<>());
        }

        // Populate adjacency list from the given graph
        for (int i = 0; i < V; i++) {
            for (int x : adj.get(i))
                g.get(i).add(x);
        }

        boolean isCycle = false;

        // Iterate over all nodes and perform DFS if not visited
        for (int i = 0; i < V; i++) {
            if (!vis[i])
                isCycle = isCycle || dfs(i, -1);
        }

        return isCycle;
    }
}
