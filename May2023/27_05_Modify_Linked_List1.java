// Link: https://practice.geeksforgeeks.org/problems/modify-linked-list-1/1/?track=MD-Math&batchId=144#
// Time Complexity: O(N)
// Space Complexity: O(N)

Node modifyTheList(Node head) {
    Node temp = head; // Creating a temporary node to traverse the linked list
    List<Integer> list = new ArrayList<>(); // Creating a list to store the values of the linked list

    // Traversing the original linked list and store the values in a list
    while (temp != null) {
        list.add(temp.data);
        temp = temp.next;
    }

    int low = 0, high = list.size() - 1; // Intailising the low and high pointers

    // Reversing the values in the list
    while (low <= high) {
        int tempVal = list.get(low);
        list.set(low, list.get(high) - list.get(low)); 
        list.set(high, tempVal);
        low++;
        high--;
    }

    // Creating a new linked list using the modified values
    Node newNode = new Node(list.get(0));
    Node hd = newNode;

    // Traversing the list and create a new node for each value
    for (int i = 1; i < list.size(); i++) {
        Node tempNode = new Node(list.get(i));
        hd.next = tempNode;
        hd = tempNode;
    }

    hd.next = null; // Updating the last node's next pointer to null
    return newNode; // Returning the modified linked list
}
