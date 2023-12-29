// Link: https://www.geeksforgeeks.org/problems/print-diagonally1623/1
// Time Complexity: O(m*n)
// Space Complexity: O(m*n)

class Solution
{
    public int[] antiDiagonalPattern(int[][] matrix)
    {
        List<Integer> result = new ArrayList<>();

        // Iterate over the top row
        for (int j = 0; j < matrix[0].length; j++) {
            result.add(matrix[0][j]);
            int row = 1;
            int col = j - 1;

            // Traverse the anti-diagonal elements
            while (row < matrix.length && col >= 0) {
                result.add(matrix[row][col]);
                row++;
                col--;
            }
        }

        // Iterate over the rightmost column
        for (int i = 1; i < matrix.length; i++) {
            result.add(matrix[i][matrix[i].length - 1]);
            int row = i + 1;
            int col = matrix[i].length - 2;

            // Traverse the anti-diagonal elements
            while (row < matrix.length && col >= 0) {
                result.add(matrix[row][col]);
                row++;
                col--;
            }
        }

        // Convert List<Integer> to int[]
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}