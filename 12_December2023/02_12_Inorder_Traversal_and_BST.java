// Link: https://www.geeksforgeeks.org/problems/inorder-traversal-and-bst5855/1
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution
{
    static int isRepresentingBST(int arr[], int N)
    {
        // Check if the array is empty or has only one element
        if (N <= 1) {
            return 1; // It represents a BST
        }

        // Traverse the array and check if it is in non-decreasing order
        for (int i = 1; i < N; i++) {
            if (arr[i] <= arr[i - 1]) {
                return 0; // It does not represent a BST
            }
        }

        return 1; // It represents a BST
    }
}
