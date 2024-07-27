// Link: https://practice.geeksforgeeks.org/problems/form-a-palindrome1455/1
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

class Solution {
    static int countMin(String str) {
        int n = str.length();
        int[][] arr = new int[n][n];
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                int k = j + i - 1;
                ;
                if (str.charAt(j) == str.charAt(k)) {
                    arr[j][k] = arr[j + 1][k - 1];
                } else {
                    arr[j][k] = Math.min(arr[j + 1][k], arr[j][k - 1]) + 1;
                }
            }
        }
        return arr[0][n - 1];
    }
}