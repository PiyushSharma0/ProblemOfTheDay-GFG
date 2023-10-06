// Link: https://practice.geeksforgeeks.org/problems/given-a-linked-list-reverse-alternate-nodes-and-append-at-the-end/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public static void rearrange(Node odd) {
        if (odd == null || odd.next == null) {
            return; // No need to rearrange if the list has 0 or 1 node.
        }
        
        Node originalHead = odd;
        Node extractedHead = odd.next;
        
        // Separate the original list from the extracted list.
        Node currentOriginal = originalHead;
        Node currentExtracted = extractedHead;
        
        while (currentOriginal != null && currentExtracted != null) {
            currentOriginal.next = currentExtracted.next;
            currentOriginal = currentOriginal.next;
            
            if (currentOriginal != null) {
                currentExtracted.next = currentOriginal.next;
                currentExtracted = currentExtracted.next;
            }
        }
        
        // Reverse the extracted list in-place.
        Node prev = null;
        Node current = extractedHead;
        Node nextNode;
        
        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        
        extractedHead = prev; // New head of the reversed list.
        
        // Append the reversed extracted list at the end of the original list.
        currentOriginal = originalHead;
        while (currentOriginal.next != null) {
            currentOriginal = currentOriginal.next;
        }
        
        currentOriginal.next = extractedHead;
    }
}
