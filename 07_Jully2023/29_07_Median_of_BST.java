// Link: https://practice.geeksforgeeks.org/problems/median-of-bst/1
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.ArrayList;
import java.util.List;

class Node
{
    int data;
    Node left, right;
    
    Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}

class Tree
{
    // Helper function to perform an in-order traversal and store elements in a list
    private static void inOrderTraversal(Node root, List<Integer> sortedList)
    {
        if (root == null)
            return;
        
        inOrderTraversal(root.left, sortedList);
        sortedList.add(root.data);
        inOrderTraversal(root.right, sortedList);
    }

    public static float findMedian(Node root)
    {
        List<Integer> sortedList = new ArrayList<>();
        inOrderTraversal(root, sortedList);

        int n = sortedList.size();
        if (n % 2 == 1)
        {
            // If the number of elements is odd, return the middle element
            return sortedList.get(n / 2);
        }
        else
        {
            // If the number of elements is even, return the average of the two middle elements
            int middle1 = sortedList.get(n / 2 - 1);
            int middle2 = sortedList.get(n / 2);
            return (middle1 + middle2) / 2.0f;
        }
    }
}
