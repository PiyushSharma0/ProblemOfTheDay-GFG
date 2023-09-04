// Link: https://practice.geeksforgeeks.org/problems/replace-os-with-xs/0
// Time Complexity: O(n*m)
// Space Complexity: O(n*m)

class Solution {
    // Define the possible directions (up, down, left, right)
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    // Helper function to check if a cell is within the matrix boundaries
    boolean isValid(int ii, int jj, int n, int m) {
        return (ii >= 0 && jj >= 0 && ii < n && jj < m);
    }

    // Helper function to check if a cell is on the boundary of the matrix
    boolean isBoundary(int i, int j, int n, int m) {
        return (i == 0 || j == 0 || i == n - 1 || j == m - 1);
    }

    // Recursive function to mark 'O's that are not closed by 'X'
    void setNotClosed(int i, int j, int n, int m, char[][] mat) {
        // Mark the cell as 'N'
        mat[i][j] = 'N';

        // Explore the four neighboring cells
        for (int d = 0; d < 4; ++d) {
            int ii = dx[d] + i;
            int jj = dy[d] + j;
            // If the neighboring cell is valid and contains 'O', mark it as 'N'
            if (isValid(ii, jj, n, m) && mat[ii][jj] == 'O') {
                setNotClosed(ii, jj, n, m, mat);
            }
        }
    }

    // Main function to replace 'O's surrounded by 'X' with 'X'
    char[][] fill(int n, int m, char[][] mat) {
        // Step 1: Traverse the matrix and mark 'O's on the boundary as 'N'
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (isBoundary(i, j, n, m) && mat[i][j] == 'O') {
                    setNotClosed(i, j, n, m, mat);
                }
            }
        }

        // Step 2: Replace 'O's with 'X' and 'N's with 'O'
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                } else if (mat[i][j] == 'N') {
                    mat[i][j] = 'O';
                }
            }
        }

        return mat;
    }
}
