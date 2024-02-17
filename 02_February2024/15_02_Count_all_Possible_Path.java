// Link: https://www.geeksforgeeks.org/problems/castle-run3644/1
// Time Complexity: O(n^2)
// Space Complexity: O(1)

class Solution {
    public int isPossible(int[][] paths) {
        int n = paths.length;

        // Check the degree of each vertex
        for (int i = 0; i < n; i++) {
            int degree = 0;
            for (int j = 0; j < n; j++) {
                degree += paths[i][j];
            }
            if (degree % 2 != 0) {
                // If any vertex has an odd degree, return 0
                return 0;
            }
        }

        return 1;
    }
}