// Link: https://practice.geeksforgeeks.org/problems/find-the-string-in-grid0111/1
// Time Complexity: O(n * m * l) where n and m are the number of rows and columns in the grid and l is the length of the word
// Space Complexity: O(1)

import java.util.*;

class Solution
{
    private static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public int[][] searchWord(char[][] grid, String word)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        int wordLength = word.length();
        List<int[]> occurrences = new ArrayList<>(); // Stores found occurrences

        // Iterate through each cell in the grid
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                // Check if the current cell's character matches the first character of the word
                if (grid[i][j] == word.charAt(0))
                {
                    // Explore each of the eight possible directions
                    for (int dir = 0; dir < 8; dir++)
                    {
                        int x = i + dx[dir]; // Move in the x direction
                        int y = j + dy[dir]; // Move in the y direction
                        boolean found = true; // Flag to track if the word is found in this direction

                        // Check if the rest of the characters in the word can be formed in this direction
                        for (int k = 1; k < wordLength; k++)
                        {
                            // Check for out-of-bounds or mismatched characters
                            if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] != word.charAt(k))
                            {
                                found = false;
                                break;
                            }

                            // Move in the same direction
                            x += dx[dir];
                            y += dy[dir];
                        }

                        // If the word is found in this direction, add the starting coordinates to the list
                        if (found)
                        {
                            occurrences.add(new int[]{i, j});
                            break; // No need to check other directions from this cell
                        }
                    }
                }
            }
        }

        // Convert the list of occurrences to a 2D array for the result
        int[][] result = new int[occurrences.size()][2];
        for (int i = 0; i < occurrences.size(); i++)
        {
            result[i] = occurrences.get(i);
        }

        return result;
    }
}
