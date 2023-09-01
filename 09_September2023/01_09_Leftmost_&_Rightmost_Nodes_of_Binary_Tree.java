// Link: https://practice.geeksforgeeks.org/problems/leftmost-and-rightmost-nodes-of-binary-tree/1
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Tree {
    public void printCorner(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            Node first = q.peek();
            Node last = null;

            for (int i = 0; i < sz; i++) {
                last = q.poll();
                if (last.left != null)
                    q.offer(last.left);
                if (last.right != null)
                    q.offer(last.right);
            }

            if (first != last)
                System.out.print(first.data + " " + last.data + " ");
            else
                System.out.print(first.data + " ");
        }
    }
}