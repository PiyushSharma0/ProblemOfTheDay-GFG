// Link: https://practice.geeksforgeeks.org/problems/making-a-large-island/1
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

import java.util.*;

class Solution {
    public int largestIsland(int N, int[][] grid) {
        int maxIslandSize = 0;
        Map<Integer, Integer> islandSizes = new HashMap<>(); // Map to store island sizes

        int islandIndex = 2; // 1 is already used for the '1's
        // Iterate through the grid to find island sizes
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    int islandSize = dfs(grid, i, j, islandIndex);
                    islandSizes.put(islandIndex, islandSize);
                    maxIslandSize = Math.max(maxIslandSize, islandSize);
                    islandIndex++;
                }
            }
        }

        // Iterate through the grid again to find maximum island size after changing '0's to '1's
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighboringIslands = new HashSet<>();
                    int potentialSize = 1; // Count the current '0' cell
                    for (int[] dir : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                        int newRow = i + dir[0];
                        int newCol = j + dir[1];
                        if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N) {
                            int neighbor = grid[newRow][newCol];
                            if (neighbor > 1) {
                                neighboringIslands.add(neighbor);
                            }
                        }
                    }
                    for (int neighbor : neighboringIslands) {
                        potentialSize += islandSizes.get(neighbor);
                    }
                    maxIslandSize = Math.max(maxIslandSize, potentialSize);
                }
            }
        }

        // If there are no '0' cells, return N*N (the size of the grid)
        return maxIslandSize == 0 ? N * N : maxIslandSize;
    }

    // Depth-First Search to find the size of an island
    private int dfs(int[][] grid, int row, int col, int islandIndex) {
        int N = grid.length;
        if (row < 0 || row >= N || col < 0 || col >= N || grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = islandIndex;
        int size = 1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            size += dfs(grid, row + dir[0], col + dir[1], islandIndex);
        }
        return size;
    }
}
   