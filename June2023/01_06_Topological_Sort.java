// Link: https://practice.geeksforgeeks.org/problems/topological-sort/1
// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity: O(V) since we are using a stack to store the vertices.

static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    Stack<Integer> stack = new Stack<>();
        
    // Perform DFS on each unvisited vertex
    for (int i = 0; i < V; i++) {
        if (!visited[i]) {
            dfs(i, adj, visited, stack);
        }
    }
        
    int[] result = new int[V];
    int index = 0;
        
    // Pop elements from stack to get the topological ordering
    while (!stack.isEmpty()) {
        result[index++] = stack.pop();
    }
        
    return result;
}
    
static void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
    visited[v] = true;
        
    // Recursively visit all adjacent vertices
    for (int neighbor : adj.get(v)) {
        if (!visited[neighbor]) {
            dfs(neighbor, adj, visited, stack);
        }
    }
        
    // Push the current vertex to the stack
    stack.push(v);
}