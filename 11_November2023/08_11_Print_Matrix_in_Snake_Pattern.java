// Link: https://practice.geeksforgeeks.org/problems/print-matrix-in-snake-pattern-1587115621/1
// Time Complexity: O(n^2) where n is the number of rows and columns in the matrix
// Space Complexity: O(1)

import java.util.ArrayList;

class Solution {
    // Function to return a list of integers visited in a snake pattern in a matrix.
    static ArrayList<Integer> snakePattern(int matrix[][]) {
        ArrayList<Integer> result = new ArrayList<>();
        int N = matrix.length;
        
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                // Even rows (0-based) are read from left to right
                for (int j = 0; j < N; j++) {
                    result.add(matrix[i][j]);
                }
            } else {
                // Odd rows are read from right to left
                for (int j = N - 1; j >= 0; j--) {
                    result.add(matrix[i][j]);
                }
            }
        }
        
        return result;
    }
}
