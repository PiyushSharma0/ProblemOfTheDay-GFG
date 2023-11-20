// Link: https://practice.geeksforgeeks.org/problems/k-sum-paths/1
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class Solution {
    public int sumK(Node root, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1); // Initialize with 0 prefix sum count
        return traversal(root, mp, k, 0);
    }

    private int traversal(Node root, Map<Integer, Integer> mp, int k, int sum) {
        if (root == null) return 0;

        int res = 0;
        int currSum = sum + root.data;

        // Check if there exists a prefix sum (currSum - k) in the map
        if (mp.containsKey(currSum - k))
            res += mp.get(currSum - k);

        // Update the prefix sum count in the map
        mp.put(currSum, mp.getOrDefault(currSum, 0) + 1);

        // Recursively traverse the left and right subtrees
        res += traversal(root.left, mp, k, currSum);
        res += traversal(root.right, mp, k, currSum);

        // Backtrack: Decrement the current prefix sum count
        mp.put(currSum, mp.get(currSum) - 1);

        return res;
    }
}
