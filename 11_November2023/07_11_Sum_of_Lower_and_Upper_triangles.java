// Link: https://practice.geeksforgeeks.org/problems/sum-of-upper-and-lower-triangles-1587115621/1
// Time Complexity: O(n^2) where n is the number of rows and columns in the matrix
// Space Complexity: O(1)

import java.util.ArrayList;

class Solution
{
    //Function to return sum of upper and lower triangles of a matrix.
    static ArrayList<Integer> sumTriangles(int matrix[][], int n) {
        ArrayList<Integer> result = new ArrayList<>();

        int upperTriangleSum = 0;
        int lowerTriangleSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Sum the upper triangle elements (i <= j)
                if (i <= j) {
                    upperTriangleSum += matrix[i][j];
                }

                // Sum the lower triangle elements (i >= j)
                if (i >= j) {
                    lowerTriangleSum += matrix[i][j];
                }
            }
        }

        result.add(upperTriangleSum);
        result.add(lowerTriangleSum);

        return result;
    }
}