// Link: https://practice.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1
// Time Complexity: O((V+E)logV)
// Space Complexity: O(V+E)

import java.util.*;

class Solution {
    static class Edge {
        int node;
        int weight;
        
        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.node;
            int currentWeight = current.weight;

            if (currentWeight > dist[u]) continue;

            for (Edge edge : graph[u]) {
                int v = edge.node;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u;
                    pq.add(new Edge(v, dist[v]));
                }
            }
        }
        if (dist[n] == Integer.MAX_VALUE) {
            return Collections.singletonList(-1);
        }
        List<Integer> path = new ArrayList<>();
        for (int at = n; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        path.add(0, dist[n]);

        return path;
    }
}