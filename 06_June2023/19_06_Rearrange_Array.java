// Link: https://practice.geeksforgeeks.org/problems/rearrange-an-array-with-o1-extra-space3142/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    static void arrange(long arr[], int n) {
        for (int i = 0; i < n; i++) {
            // Calculate the new value for arr[i]
            // using the expression arr[i] += (arr[(int)arr[i]] % n) * n

            // Retrieve the original value at index arr[i] using arr[(int)arr[i]]
            // Take modulo n to ensure the value is within the range [0, n-1]
            // Multiply by n to shift the original value to the leftmost digit

            arr[i] += (arr[(int)arr[i]] % n) * n;
        }
        
        for (int i = 0; i < n; i++) {
            // Divide each element by n to obtain the transformed values

            arr[i] /= n;
        }
    }
}
