// Link: https://practice.geeksforgeeks.org/problems/predict-the-column-java/1
// Time Complexity: O(n^2) where n is the number of rows and columns in the matrix
// Space Complexity: O(1)

class Solution
{
    int columnWithMaxZeros(int arr[][], int N)
    {
        int maxZeros = 0; // Initialize the maximum number of zeros
        int maxZerosColumn = -1; // Initialize the column with max zeros

        // Iterate through each column
        for (int j = 0; j < N; j++) {
            int currentZeros = 0; // Count of zeros in the current column

            // Iterate through each row in the current column
            for (int i = 0; i < N; i++) {
                if (arr[i][j] == 0) {
                    currentZeros++;
                }
            }

            // Update maxZerosColumn if the current column has more zeros
            if (currentZeros > maxZeros) {
                maxZeros = currentZeros;
                maxZerosColumn = j;
            }
        }

        return maxZeros == 0 ? -1 : maxZerosColumn;
    }
}
