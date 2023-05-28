// Link : https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
// Time Complexity : O(n)
// Space Complexity : O(1)

int getNthFromLast(Node head, int n)
    {
    	if (head == null || n <= 0) {
            return -1; // Invalid input or node not found
        }
        Node slow = head;
        Node fast = head;

        // Move the fast pointer N nodes ahead 
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return -1; // N is greater than the length of the list
            }
            fast = fast.next;
        }
        // Move both pointers until the fast pointer reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;	
    }