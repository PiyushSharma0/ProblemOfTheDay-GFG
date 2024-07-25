// Link: https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1
// Time Complexity: O(N1 + N2 + (N1 + N2)log(N1 + N2)) = O((N1 + N2)log(N1 + N2)) where N1 and N2 are the number of nodes in the two BSTs
// Space Complexity: O(N1 + N2) where N1 and N2 are the number of nodes in the two BSTs

class Solution {
    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> sortedList = new ArrayList<>();
        inOrderTraversal(root1, sortedList);
        inOrderTraversal(root2, sortedList);
        sortedList.sort(Integer::compareTo);
        return sortedList;
    }
    
    private void inOrderTraversal(Node root, List<Integer> sortedList) {
        if (root == null) return;
        inOrderTraversal(root.left, sortedList);
        sortedList.add(root.data);
        inOrderTraversal(root.right, sortedList);
    }
}