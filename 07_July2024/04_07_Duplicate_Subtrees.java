// Link: https://www.geeksforgeeks.org/problems/duplicate-subtrees/1
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public List<Node> printAllDups(Node root) {
        List<Node> list = new ArrayList<>();
        HashMap<String, Integer> hash = new HashMap<>();
        find(root, list, hash);
        return list;

    }

    public String find(Node root, List<Node> list, HashMap<String, Integer> hash) {

        if (root == null)
            return "N";
        String str = root.data + "," + find(root.left, list, hash) + "," + find(root.right, list, hash);
        if (hash.containsKey(str))
            hash.put(str, hash.get(str) + 1);
        else
            hash.put(str, 1);
        if (hash.get(str) == 2) {
            list.add(root);
        }

        return str;
    }
}