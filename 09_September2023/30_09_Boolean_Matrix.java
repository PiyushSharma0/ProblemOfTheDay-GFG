// Link: https://practice.geeksforgeeks.org/problems/boolean-matrix-problem-1587115620/
// Time Complexity: O(m*n) where m is the number of rows and n is the number of columns
// Space Complexity: O(1)

class Solution {
    // Function to modify the matrix such that if a matrix cell matrix[i][j]
    // is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][]) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean rowHasOne = false;
        boolean colHasOne = false;

        // Check if the first row needs to be updated.
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 1) {
                rowHasOne = true;
                break;
            }
        }

        // Check if the first column needs to be updated.
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 1) {
                colHasOne = true;
                break;
            }
        }

        // Use the first row and first column to mark cells for updates.
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][0] = 1;
                    matrix[0][j] = 1;
                }
            }
        }

        // Modify the matrix based on the marked cells.
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 1 || matrix[0][j] == 1) {
                    matrix[i][j] = 1;
                }
            }
        }

        // Update the first row and first column if needed.
        if (rowHasOne) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 1;
            }
        }
        if (colHasOne) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 1;
            }
        }
    }
}

