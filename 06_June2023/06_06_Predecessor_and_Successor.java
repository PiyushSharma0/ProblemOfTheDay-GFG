// Link: https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1
// Time complexity: O(h) where h is the height of the tree
// Space complexity: O(1)

public static void findPreSuc(Node root, int key) {
    Node pre = null, suc = null;

    pre = floor(root, key);
    suc = ceil(root, key);

    System.out.println("Key: " + key);
    System.out.println("Predecessor: " + (pre != null ? pre.key : "null"));
    System.out.println("Successor: " + (suc != null ? suc.key : "null"));
}

static Node ceil(Node root, int x) {
    Node res = null;
    while (root != null) {
        if (root.key == x) {
            return root;
        } else if (root.key > x) {
            res = root;
            root = root.left;
        } else {
            root = root.right;
        }
    }
    return res;
}

static Node floor(Node root, int x) {
    Node res = null;
    while (root != null) {
        if (root.key == x) {
            return root;
        } else if (root.key < x) {
            res = root;
            root = root.right;
        } else {
            root = root.left;
        }
    }
    return res;
}
