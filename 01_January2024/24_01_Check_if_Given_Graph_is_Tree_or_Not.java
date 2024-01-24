// Link: https://practice.geeksforgeeks.org/problems/check-if-given-graph-is-tree-or-not/1/?track=md-graph&batchId=144#
// Time Complexity: O(V + E) V = number of vertices, E = number of edges
// Space Complexity: O(V + E) (for the adjacency list) + O(V) (for the visited array)

class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // Create an array to keep track of visited nodes
        boolean[] visited = new boolean[n];

        // Create an adjacency list to represent the graph
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Populate the adjacency list
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        // Check if the graph is connected and acyclic
        if (isConnectedAndAcyclic(adjacencyList, visited, 0, -1) && allNodesVisited(visited)) {
            return true;
        }

        return false;
    }

    private boolean isConnectedAndAcyclic(ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited, int node, int parent) {
        visited[node] = true;

        // Traverse all adjacent nodes
        for (int neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor]) {
                // If the neighbor is not visited, continue DFS
                if (!isConnectedAndAcyclic(adjacencyList, visited, neighbor, node)) {
                    return false;
                }
            } else if (neighbor != parent) {
                // If the neighbor is already visited and not the parent, there is a cycle
                return false;
            }
        }

        return true;
    }

    private boolean allNodesVisited(boolean[] visited) {
        // Check if all nodes have been visited
        for (boolean isVisited : visited) {
            if (!isVisited) {
                return false;
            }
        }
        return true;
    }
}