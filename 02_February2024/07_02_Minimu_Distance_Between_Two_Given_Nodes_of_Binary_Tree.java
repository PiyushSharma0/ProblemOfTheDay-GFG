// Link: https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1
// Time Complexity: O(N)
// Space Complexity: O(N)

class GfG {
    // Utility class to store distance and whether the target node is found
    static class Result {
        int distance;
        boolean found;

        Result(int distance, boolean found) {
            this.distance = distance;
            this.found = found;
        }
    }

    // Helper function to find the distance and whether the target node is found
    private Result findDistance(Node root, int target) {
        if (root == null) {
            return new Result(0, false);
        }

        if (root.data == target) {
            return new Result(0, true);
        }

        Result leftResult = findDistance(root.left, target);
        Result rightResult = findDistance(root.right, target);

        if (leftResult.found) {
            return new Result(leftResult.distance + 1, true);
        } else if (rightResult.found) {
            return new Result(rightResult.distance + 1, true);
        }

        return new Result(0, false);
    }

    // Helper function to find the lowest common ancestor
    private Node findLCA(Node root, int a, int b) {
        if (root == null) {
            return null;
        }

        if (root.data == a || root.data == b) {
            return root;
        }

        Node leftLCA = findLCA(root.left, a, b);
        Node rightLCA = findLCA(root.right, a, b);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    // Main function to find the minimum distance between two nodes
    int findDist(Node root, int a, int b) {
        Node lca = findLCA(root, a, b);

        Result distanceFromA = findDistance(lca, a);
        Result distanceFromB = findDistance(lca, b);

        return distanceFromA.distance + distanceFromB.distance;
    }
}
