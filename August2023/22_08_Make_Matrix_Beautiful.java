// Link: https://practice.geeksforgeeks.org/problems/make-matrix-beautiful-1587115620/
// Time Complexity: O(n^2)
// Space Complexity: O(1)

class Solution {
    public static int findMinOperation(int n, int[][] a) {
        long sumRow, sumCol;
        long maxRow = 0, maxCol = 0, total = 0;

        for (int i = 0; i < n; i++) {
            sumRow = sumCol = 0;

            for (int j = 0; j < n; j++) {
                sumRow += a[i][j]; // Calculate the sum of elements in the current row
                sumCol += a[j][i]; // Calculate the sum of elements in the current column
                total += a[i][j];  // Calculate the total sum of all elements
            }

            maxRow = Math.max(maxRow, sumRow); // Update the maximum row sum
            maxCol = Math.max(maxCol, sumCol); // Update the maximum column sum
        }

        // Calculate the minimum number of operations
        return (int)(Math.max(maxRow * n, maxCol * n) - total);
    }
}