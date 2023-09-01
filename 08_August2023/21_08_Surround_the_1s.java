// Link: https://practice.geeksforgeeks.org/problems/surround-the-1s2505/1
// Time Complexity: O(n*m)
// Space Complexity: O(1)

class Solution {
    // Array to represent the possible directions to move in
    int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    // Function to check if a cell is valid within the grid
    boolean isValid(int ii, int jj, int n, int m) {
        return ii < n && ii >= 0 && jj < m && jj >= 0;
    }

    // Main function to count specific cells in a matrix
    int Count(int[][] mat) {
        int cnt = 0;
        int n = mat.length; // Get the number of rows (length)
        int m = mat[0].length; // Get the number of columns (length)

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (mat[i][j] == 1) { // Check if the current cell contains 1
                    int c = 0; // Counter for valid neighbors

                    // Iterate through all 8 possible directions
                    for (int k = 0; k < 8; ++k) {
                        int ii = dx[k] + i; // Calculate the new row index
                        int jj = dy[k] + j; // Calculate the new column index
                        
                        // Check if the new cell is within bounds and contains 0
                        if (isValid(ii, jj, n, m) && mat[ii][jj] == 0)
                            ++c; // Increment the counter for each valid neighbor
                    }
                    
                    // If there are an even number of valid neighbors, increment the count
                    if (c > 0 && c % 2 == 0)
                        ++cnt;
                }
            }
        }

        return cnt; // Return the final count
    }
}
