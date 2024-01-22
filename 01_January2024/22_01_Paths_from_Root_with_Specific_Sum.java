// Link: https://practice.geeksforgeeks.org/problems/paths-from-root-with-sum/1
// Time Complexity: O(N) N = number of nodes in the tree
// Space Complexity: O(N) (for the recursive stack) + O(N) (for the result array)

class Solution
{
    public static void solve(Node root, int s, int sum, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> result) {
        if (root == null)
            return;

        currentPath.add(root.data);
        s += root.data;

        if (s == sum) {
            result.add(new ArrayList<>(currentPath));
        }

        solve(root.left, s, sum, currentPath, result);
        solve(root.right, s, sum, currentPath, result);

        // Backtrack: Remove the last element to explore other paths
        currentPath.remove(currentPath.size() - 1);
    }

    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentPath = new ArrayList<>();
        solve(root, 0, sum, currentPath, result);
        return result;
    }
}