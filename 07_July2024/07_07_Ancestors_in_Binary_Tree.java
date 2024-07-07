// Link: https://practice.geeksforgeeks.org/problems/ancestors-in-binary-tree/1
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.ArrayList;

class Node {
    int data;
    Node left, right;
    Node(int key) {
        data = key;
        left = right = null;
    }
}

class Solution {
    public boolean ancestor(Node root, int target, ArrayList<Integer> result) {
        if(root == null) {
            return false;
        }
        if(root.data == target) {
            return true;
        }

        if(ancestor(root.left, target, result) || ancestor(root.right, target, result)) {
            result.add(root.data);
            return true;
        }
        return false;
    }

    public ArrayList<Integer> Ancestors(Node root, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        ancestor(root, target, result);
        return result;
    }
}