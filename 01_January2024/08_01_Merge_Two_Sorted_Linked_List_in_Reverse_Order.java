// Link: https://www.geeksforgeeks.org/problems/merge-2-sorted-linked-list-in-reverse-order/1
// Time Complexity: O(N * log(N))
// Space Complexity: O(N)

class GfG
{
     Node mergeResult(Node node1, Node node2)
    {
        LinkedList<Integer> mergedList = new LinkedList<>();
        while (node1 != null) {
            mergedList.add(node1.data);
            node1 = node1.next;
        }
        while (node2 != null) {
            mergedList.add(node2.data);
            node2 = node2.next;
        }

        Collections.sort(mergedList, Collections.reverseOrder());

        Node dummy = new Node(0);
        Node current = dummy;
        for (int value : mergedList) {
            current.next = new Node(value);
            current = current.next;
        }

        return dummy.next;
    }
}