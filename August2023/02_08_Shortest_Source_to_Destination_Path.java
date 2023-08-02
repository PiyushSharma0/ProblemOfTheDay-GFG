// Link: https://practice.geeksforgeeks.org/problems/shortest-source-to-destination-path3544/1
// Time Complexity: O(N*M) where N is the number of rows and M is the number of columns
// Space Complexity: O(N*M) where N is the number of rows and M is the number of columns

import java.util.*;

class Solution {
    // Class to store coordinates (x, y) and distance from starting point
    static class Point {
        int x, y, dist;

        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // Possible movement directions: up, down, left, right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // Create a queue for BFS and a visited array to mark visited cells
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        // Start BFS from the origin (0, 0) with distance 0
        queue.offer(new Point(0, 0, 0));
        visited[0][0] = true;

        // Perform BFS
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int x = current.x;
            int y = current.y;
            int dist = current.dist;

            // Check if the current cell is the destination (X, Y)
            if (x == X && y == Y) {
                return dist; // Return the distance if destination reached
            }

            // Explore neighboring cells in all directions
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // Check if the new coordinates are within the grid and reachable
                if (newX >= 0 && newX < N && newY >= 0 && newY < M && A[newX][newY] == 1 && !visited[newX][newY]) {
                    // Enqueue the new point with updated distance and mark as visited
                    queue.offer(new Point(newX, newY, dist + 1));
                    visited[newX][newY] = true;
                }
            }
        }

        return -1; // Destination not reachable
    }
}
