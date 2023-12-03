// Link: https://practice.geeksforgeeks.org/problems/brothers-from-different-root/1#
// Time Complexity: O(n + m) where n and m are the number of nodes in the first and second BST respectively
// Space Complexity: O(n1 + n2) where n1 and n2 are the number of nodes in the first and second BST respectively

import java.util.HashSet;

class Solution
{
    public static int countPairs(Node root1, Node root2, int x)
    {
        // Step 1: Traverse and store nodes of the first BST in a HashSet
        HashSet<Integer> set = new HashSet<>();
        storeNodesInSet(root1, set);

        // Step 2: Traverse the second BST and count pairs with sum equal to x
        return countPairsInBST(root2, set, x);
    }

    // Helper function to store nodes of a BST in a HashSet
    private static void storeNodesInSet(Node root, HashSet<Integer> set)
    {
        if (root == null) {
            return;
        }

        storeNodesInSet(root.left, set);
        set.add(root.data);
        storeNodesInSet(root.right, set);
    }

    // Helper function to count pairs with sum equal to x in a BST
    private static int countPairsInBST(Node root, HashSet<Integer> set, int x)
    {
        if (root == null) {
            return 0;
        }

        int count = countPairsInBST(root.left, set, x);

        if (set.contains(x - root.data)) {
            count++;
        }

        count += countPairsInBST(root.right, set, x);

        return count;
    }
}
