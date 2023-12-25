// Link: https://practice.geeksforgeeks.org/problems/determinant-of-a-matrix-1587115620/1
// Time Complexity: O(N!) (N factorial is the time complexity of the determinant of a matrix)
// Space Complexity: O(N^2)

class Solution
{
    // Function for finding determinant of matrix.
    static int determinantOfMatrix(int matrix[][], int n)
    {
        if (n == 1) {
            return matrix[0][0];
        }
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int sign = 1, ans = 0;
        int[][] m = new int[n - 1][n - 1];

        for (int row = 0; row < n; ++row) {
            int k = 0;
            for (int i = 0; i < n; ++i) {
                if (i != row) {
                    for (int j = 1; j < n; ++j)
                        m[k][j - 1] = matrix[i][j];

                    k++;
                }
            }
            ans += sign * (matrix[row][0]) * determinantOfMatrix(m, n - 1);
            sign *= -1;
        }
        return ans;
    }
}
