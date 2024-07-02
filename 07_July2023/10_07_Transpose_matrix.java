// Link|: https://practice.geeksforgeeks.org/problems/transpose-of-matrix-1587115621/1
// Time Complexity: O(n^2)
// Space Complexity: O(1)

class Solution
{
    public void transpose(int n,int a[][])
    {
          for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap elements (i, j) and (j, i)
                a[i][j] = a[i][j] + a[j][i];
                a[j][i] = a[i][j] - a[j][i];
                a[i][j] = a[i][j] - a[j][i];
            }
        }
    }
}