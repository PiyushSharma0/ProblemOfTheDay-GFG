// Link: https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1#
// Time Complexity: O(N^2)
// Space Complexity: O(N)

import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
   public String isDuplicateSubtree(Node root, Map<String, Integer> subtreeCount) {
        if (root == null) {
            return "";
        }

        // Serialize the subtree rooted at 'root' into a string
        String subtree = root.data + " " +
                isDuplicateSubtree(root.left, subtreeCount) + " " +
                isDuplicateSubtree(root.right, subtreeCount);

        // If we've seen this subtree before, increment its count
        subtreeCount.put(subtree, subtreeCount.getOrDefault(subtree, 0) + 1);

        // If the count is 2 or more, it's a duplicate subtree
        return subtreeCount.get(subtree) == 2 ? subtree : "";
    }

    public int dupSub(Node root) {
        Map<String, Integer> subtreeCount = new HashMap<>();
        isDuplicateSubtree(root, subtreeCount);
        for (Map.Entry<String, Integer> entry : subtreeCount.entrySet()) {
            if (entry.getValue() >= 2) {
                return 1; // Duplicate subtree found
            }
        }
        return 0; // No duplicate subtree found
    }
}