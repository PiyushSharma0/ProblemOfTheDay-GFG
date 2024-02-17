// Link: https://www.geeksforgeeks.org/problems/clone-graph/1
// Time Complexity: O(n)
// Space Complexity: O(n)

    int val;
    ArrayList<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

class Solution {
    Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node clonedNode = new Node(node.val, new ArrayList<>());
        visited.put(node, clonedNode);

        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbor));
        }

        return clonedNode;
    }
}