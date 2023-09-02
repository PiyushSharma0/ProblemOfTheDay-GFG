// Link: https://practice.geeksforgeeks.org/problems/leaf-under-budget/1
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int getCount(Node root, int k) {
        // Create a queue of pairs, where each pair consists of a Node and its level.
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        
        // Add the root node along with its level (starting at 1) to the queue.
        q.add(new Pair<>(root, 1));
        
        // Initialize a counter for counting leaf nodes satisfying the condition.
        int cnt = 0;

        // Continue the loop as long as the queue is not empty and k is greater than 0.
        while (!q.isEmpty() && k > 0) {
            // Dequeue a pair from the front of the queue.
            Pair<Node, Integer> pair = q.poll();
            
            // Extract the node and its level from the pair.
            Node node = pair.getKey();
            int level = pair.getValue();

            // Check if the current node is a leaf node (has no left and right children).
            if (node.left == null && node.right == null) {
                // If the level of the leaf node is greater than k, return the current count.
                if (level > k)
                    return cnt;

                // Increment the count and subtract the level from k.
                ++cnt;
                k -= level;
            } else {
                // If the current node is not a leaf node, enqueue its left and right children
                // along with their levels incremented by 1.
                if (node.left != null)
                    q.add(new Pair<>(node.left, level + 1));
                if (node.right != null)
                    q.add(new Pair<>(node.right, level + 1));
            }
        }

        // Return the final count of leaf nodes satisfying the condition.
        return cnt;
    }
}