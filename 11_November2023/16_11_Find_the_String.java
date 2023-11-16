// Link: https://www.geeksforgeeks.org/problems/find-the-string/1
// Time Complexity: O(K)
// Space Complexity: O(N)

import java.util.HashSet;

class Solution {

    // Helper method for depth-first search
    private void dfs(int k, StringBuilder prev, HashSet<String> seen, StringBuilder edges) {
        // Iterate over characters from '0' to '0' + k - 1
        for (char i = '0'; i <= ('0' + k - 1); i++) {
            // Create the current string by appending the current character
            String cur = prev.toString() + i;
            
            // Check if the current string is not seen before
            if (!seen.contains(cur)) {
                // Mark the current string as seen
                seen.add(cur);
                
                // Recursively call DFS with the next string and update edges
                dfs(k, new StringBuilder(cur.substring(1)), seen, edges);
                
                // Append the current character to the edges
                edges.append(i);
            }
        }
    }

    // Main method to find the string
    public String findString(int n, int k) {
        // Set to keep track of seen strings
        HashSet<String> seen = new HashSet<>();
        
        // Create the starting node with (n - 1) zeros
        StringBuilder startingNode = new StringBuilder("0".repeat(Math.max(0, n - 1)));
        
        // StringBuilder to store the edges
        StringBuilder edges = new StringBuilder();
        
        // Perform DFS to generate the string and edges
        dfs(k, startingNode, seen, edges);

        // Concatenate the edges and startingNode to get the final result
        return edges.toString() + startingNode.toString();
    }
}
