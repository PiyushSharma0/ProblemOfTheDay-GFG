// Link: https://practice.geeksforgeeks.org/problems/find-k-th-element-of-matrix/1
// Time Complexity: O(n*m)
// Space Complexity: O(1)

class Solution {
    int findK(int A[][], int n, int m, int k) {
        int top = 0;       // top boundary
        int bottom = n - 1; // bottom boundary
        int left = 0;      // left boundary
        int right = m - 1; // right boundary
        int direction = 0; // 0: left to right, 1: top to bottom, 2: right to left, 3: bottom to top
        
        int count = 0;     // element count
        int element = 0;   // kth element
        
        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    count++;
                    if (count == k) {
                        element = A[top][i];
                        break;
                    }
                }
                top++;
            } else if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    count++;
                    if (count == k) {
                        element = A[i][right];
                        break;
                    }
                }
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    count++;
                    if (count == k) {
                        element = A[bottom][i];
                        break;
                    }
                }
                bottom--;
            } else if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    count++;
                    if (count == k) {
                        element = A[i][left];
                        break;
                    }
                }
                left++;
            }
            
            direction = (direction + 1) % 4; // update the direction
            if (count == k) {
                break;
            }
        }
        
        return element;
    }
}
