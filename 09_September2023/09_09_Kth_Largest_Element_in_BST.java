// Link: https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
// Time Complexity: O(H + K) where H is the height of the tree and K is the input
// Space Complexity: O(H) where H is the height of the tree

class Solution
{
    class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    // Create a class variable to keep track of the count
    private int count = 0;
    
    // Create a variable to store the Kth largest element
    private int kthLargestElement = -1;

    // Helper function to perform reverse in-order traversal
    private void reverseInOrderTraversal(Node root, int K)
    {
        if (root == null || count >= K) {
            return;
        }

        // Recur on the right subtree first
        reverseInOrderTraversal(root.right, K);

        // Increment the count
        count++;

        // If the count reaches K, store the Kth largest element
        if (count == K) {
            kthLargestElement = root.data;
            return;
        }

        // Recur on the left subtree
        reverseInOrderTraversal(root.left, K);
    }

    // Function to find the Kth largest element in the BST
    public int kthLargest(Node root, int K)
    {
        // Start the reverse in-order traversal
        reverseInOrderTraversal(root, K);

        // Return the Kth largest element
        return kthLargestElement;
    }
}
