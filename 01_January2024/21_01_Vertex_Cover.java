// Link: https://practice.geeksforgeeks.org/problems/vertex-cover/0
// Time Complexity: O(2^N) N = number of vertices in the graph
// Space Complexity: O(2^N) (for the recursive stack) + O(1) (for the out array)

class Solution {
    public static void solve(int i, int bits, int n, int m, int[][] edges, int[] out) {
        if (i > n) {
            for (int j = 0; j < m; j++) {
                if ((bits & (1 << (edges[j][0] - 1))) == 0 && (bits & (1 << (edges[j][1] - 1))) == 0) {
                    return;
                }
            }
            out[0] = Math.min(out[0], Integer.bitCount(bits));
            return;
        }
        solve(i + 1, bits, n, m, edges, out);
        solve(i + 1, bits | (1 << (i - 1)), n, m, edges, out);
    }

    public static int vertexCover(int n, int m, int[][] edges) {
        int[] out = { Integer.MAX_VALUE };
        solve(1, 0, n, m, edges, out);
        return out[0];
    }
}