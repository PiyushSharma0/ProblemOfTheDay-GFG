// Link: https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
        
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    
    // Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                // For each level, only consider the last node encountered.
                if (i == levelSize - 1) {
                    result.add(currentNode.data);
                }
                
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        
        return result;
    }
}
