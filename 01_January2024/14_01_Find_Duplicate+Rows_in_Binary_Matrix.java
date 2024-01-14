// Link: https://practice.geeksforgeeks.org/problems/find-duplicate-rows-in-a-binary-matrix/1
// Time Complexity: O(M * N)
// Space Complexity: O(M * N)

import java.util.ArrayList;
import java.util.HashSet;

class Solution
{
    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n)
    {
        HashSet<String> seenRows = new HashSet<>();
        ArrayList<Integer> repeatedRowsList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            StringBuilder rowString = new StringBuilder();
            for (int j = 0; j < n; j++) {
                rowString.append(matrix[i][j]);
            }

            // Check if the row string is already in the HashSet
            if (seenRows.contains(rowString.toString())) {
                repeatedRowsList.add(i);
            } else {
                seenRows.add(rowString.toString());
            }
        }

        return repeatedRowsList;
    }
}
