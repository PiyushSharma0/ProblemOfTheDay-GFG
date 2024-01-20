// Link: https://practice.geeksforgeeks.org/problems/distribute-candies/1
// Time Complexity: O(N) N = number of nodes in the tree
// Space Complexity: O(N) (for the recursive stack) + O(1) (for the Moves object) 

class Solution
{
   static class Moves {
        int moves;

        Moves() {
            this.moves = 0;
        }
    }

    public static int distributeCandy(Node root) {
        Moves moves = new Moves();
        solve(root, moves);
        return moves.moves;
    }

    private static int solve(Node root, Moves moves) {
        if (root == null) {
            return 0;
        }

        int left = solve(root.left, moves);
        int right = solve(root.right, moves);
        moves.moves += Math.abs(left) + Math.abs(right);

        return root.data - 1 + left + right;
    }
}