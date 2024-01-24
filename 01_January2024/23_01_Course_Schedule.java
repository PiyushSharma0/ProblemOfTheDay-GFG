// Link: https://practice.geeksforgeeks.org/problems/course-schedule/1
// Time Complexity: O(V + E) V = number of vertices, E = number of edges
// Space Complexity: O(V + E) (for the adjacency list) + O(V) (for the in-degree array) + O(V) (for the topological sort array) + O(V) (for the queue)

class Solution
{
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indeg = new int[n];
        int[] toSo = new int[n];
        int idx = 0;

        // Build the adjacency list
        for (List<Integer> e : prerequisites) {
            adj.get(e.get(1)).add(e.get(0));
        }

        // Calculate in-degrees
        for (List<Integer> al : adj) {
            for (int i : al) {
                indeg[i]++;
            }
        }

        // Topological Sort using BFS
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            toSo[idx++] = curr;

            for (int i : adj.get(curr)) {
                indeg[i]--;
                if (indeg[i] == 0) {
                    q.add(i);
                }
            }
        }

        return idx == n ? toSo : new int[]{};
    }
}