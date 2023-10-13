// Link: https://practice.geeksforgeeks.org/problems/floor-in-bst/1
// Time Complexity: O(H) where H is the height of the BST
// Space Complexity: O(1)

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    public static int floor(Node root, int x) {
        int floorValue = -1; // Initialize the floor value to -1

        while (root != null) {
            if (root.data == x) {
                // If the current node's value is equal to x, return x as it is the floor value
                return x;
            } else if (root.data < x) {
                // If the current node's value is less than x, update floorValue and move to the right subtree
                floorValue = root.data;
                root = root.right;
            } else {
                // If the current node's value is greater than x, move to the left subtree
                root = root.left;
            }
        }

        return floorValue; // Return the greatest value node smaller than or equal to x
    }
}
