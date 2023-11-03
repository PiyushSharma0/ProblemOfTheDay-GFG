// Link: https://practice.geeksforgeeks.org/problems/minimum-distance-between-two-numbers/
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    int minDist(int a[], int n, int x, int y) {
        int minXIndex = -1;  // Initialize to -1 for elements x and y
        int minYIndex = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                if (minYIndex != -1) {
                    int distance = i - minYIndex;
                    minDistance = Math.min(minDistance, distance);
                }
                minXIndex = i;
            } else if (a[i] == y) {
                if (minXIndex != -1) {
                    int distance = i - minXIndex;
                    minDistance = Math.min(minDistance, distance);
                }
                minYIndex = i;
            }
        }

        if (minXIndex == -1 || minYIndex == -1) {
            // Either x or y doesn't exist in the array
            return -1;
        }

        return minDistance;
    }
}