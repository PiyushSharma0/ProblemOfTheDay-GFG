// Link: https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
// Time Complexity: O((n+m)log(n+m))
// Space Complexity: O(1)

class Solution {
    public static void merge(long arr1[], long arr2[], int n, int m) {
        int i = n - 1; // Index of last element in arr1
        int j = 0; // Index of first element in arr2

        // Iterate until there are elements in arr1 and arr2
        while (i >= 0 && j < m) {
            // If the current element in arr1 is greater than the current element in arr2,
            // swap them and move arr1's pointer to the previous element
            if (arr1[i] > arr2[j]) {
                long temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }

        // Sort arr1 in non-decreasing order
        Arrays.sort(arr1);

        // Sort arr2 in non-decreasing order
        Arrays.sort(arr2);
    }
}
