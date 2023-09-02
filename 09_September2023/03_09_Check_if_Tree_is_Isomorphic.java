// Link: https://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1#
// Time Complexity: O(n)
// Space Complexity: O(h)

class Solution {
    // Function to check if two trees are isomorphic
    boolean isIsomorphic(Node root1, Node root2) {
        // If both trees are null, they are isomorphic
        if (root1 == null && root2 == null)
            return true;

        // If one of the trees is null while the other is not, they are not isomorphic
        if (root1 == null || root2 == null)
            return false;

        // If the data of the root nodes is not the same, they are not isomorphic
        if (root1.data != root2.data)
            return false;

        // Check isomorphism for the following cases:
        // 1. Both trees are not swapping their children, and their left and right subtrees are isomorphic.
        // 2. Both trees are swapping their children, and their left-left and right-right subtrees are isomorphic,
        //    and their left-right and right-left subtrees are isomorphic.
        return (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right))
            || (isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left));
    }
}
