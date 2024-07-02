// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.ArrayList;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

class Tree {
    int data;
    Tree left;
    Tree right;
    Tree(int key) {
        data = key;
        left = right = null;
    }
}

class Solution {
    public Tree convert(Node head, Tree node) {
        ArrayList<Tree> list = new ArrayList<>();
        while (head != null) {
            list.add(new Tree(head.data));
            head = head.next;
        }

        int n = list.size();
        if (n == 0)
            return node;

        for (int i = 1; i < n; i += 2) {
            list.get(i / 2).left = list.get(i);
            if (i + 1 < n) {
                list.get(i / 2).right = list.get(i + 1);
            }
        }

        node = list.get(0);

        return node;
    }
}