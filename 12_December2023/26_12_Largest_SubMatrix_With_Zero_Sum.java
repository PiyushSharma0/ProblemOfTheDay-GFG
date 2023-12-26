// Link: https://practice.geeksforgeeks.org/problems/largest-sub-matrix-with-0-sum/0
// Time Complexity: O(n^4)
// Space Complexity: O(n^2)

import java.util.ArrayList;

class Solution {
    // Coord class to represent coordinates of a rectangle
    static class Coord {
        int x1, y1, x2, y2;

        public Coord(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    // Method to find the largest rectangular sub-matrix with a sum of 0
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        // Calculate prefix sum matrix
        int[][] pre = new int[n][m];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                pre[i][j] = a[i][j];

        // Compute cumulative sums along rows
        for (int i = 1; i < n; ++i)
            for (int j = 0; j < m; ++j)
                pre[i][j] += pre[i - 1][j];

        // Compute cumulative sums along columns
        for (int i = 0; i < n; ++i)
            for (int j = 1; j < m; ++j)
                pre[i][j] += pre[i][j - 1];

        // Variables to store information about the sub-matrix with sum 0
        Coord maxCoord = new Coord(-1, -1, -1, -1);
        int area = 0;

        // Iterate through all possible sub-matrices
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int sum = 0;
                if (i > 0 && j > 0)
                    sum += pre[i - 1][j - 1];

                // Explore all possible rectangles with the current (i, j) as the top-left corner
                for (int y = m - 1; y >= j; --y) {
                    for (int x = n - 1; x >= i; --x) {
                        if (area <= (x - i + 1) * (y - j + 1)) {
                            int s = sum + pre[x][y];
                            if (i > 0)
                                s -= pre[i - 1][y];
                            if (j > 0)
                                s -= pre[x][j - 1];

                            // Check if the sum is 0 and update maxCoord accordingly
                            if (s == 0) {
                                if (area != (x - i + 1) * (y - j + 1)) {
                                    area = (x - i + 1) * (y - j + 1);
                                    maxCoord = new Coord(i, j, x, y);
                                } else {
                                    if (maxCoord.y1 > j) {
                                        area = (x - i + 1) * (y - j + 1);
                                        maxCoord = new Coord(i, j, x, y);
                                    } else if (maxCoord.y1 == j) {
                                        if (maxCoord.x2 - maxCoord.x1 < x - i) {
                                            area = (x - i + 1) * (y - j + 1);
                                            maxCoord = new Coord(i, j, x, y);
                                        }
                                    }
                                }
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        // Construct the result matrix based on maxCoord
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (area == 0)
            return result;

        for (int i = maxCoord.x1; i <= maxCoord.x2; ++i) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = maxCoord.y1; j <= maxCoord.y2; ++j) {
                row.add(a[i][j]);
            }
            result.add(row);
        }
        return result;
    }
}
