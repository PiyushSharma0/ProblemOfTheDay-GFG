// Link: https://www.geeksforgeeks.org/problems/c-letters-collection4552/1
// Time Complexity: O(n * q) where n is the number of rows and columns in the matrix and q is the number of queries
// Space Complexity: O(1)

import java.util.ArrayList;
import java.util.List;

class Solution {
    // This function takes as input the dimensions of the matrix (n, m), the matrix itself (mat),
    // the number of queries (q), and an array of queries (queries).
    static List<Integer> matrixSum(int n, int m, int mat[][], int q, int queries[][]) {
        List<Integer> out = new ArrayList<>(); // Create a list to store the results of queries.
        
        for (int k = 0; k < q; k++) { // Iterate through each query.
            int sum = 0; // Initialize a variable to store the sum for the current query.
            int hop = queries[k][0]; // Get the hop distance from the query.
            int x = queries[k][1]; // Get the x-coordinate from the query.
            int y = queries[k][2]; // Get the y-coordinate from the query.
            
            // Loop to calculate the sum of letters within 1-hop distance from the cell (x, y).
            for (int i = x - hop; i <= x + hop; i++) {
                if (i >= 0 && i < n) { // Check if the row index is within bounds (0 to n-1).
                    if (y - hop >= 0) // Check if the column index is within bounds (0 to m-1).
                        sum += mat[i][y - hop]; // Add the letter from the neighboring cell.
                    if (y + hop < m)
                        sum += mat[i][y + hop];
                }
            }
                
            // Loop to calculate the sum of letters within 2-hop distance from the cell (x, y).
            for (int i = y - hop + 1; i < y + hop; i++) {
                if (i >= 0 && i < m) { // Check if the column index is within bounds (0 to m-1).
                    if (x - hop >= 0) // Check if the row index is within bounds (0 to n-1).
                        sum += mat[x - hop][i]; // Add the letter from the neighboring cell.
                    if (x + hop < n)
                        sum += mat[x + hop][i];
                }
            }
                
            out.add(sum); // Add the sum for the current query to the result list.
        }
        
        return out; // Return the list of query results.
    }
}
