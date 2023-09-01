// Link: https://practice.geeksforgeeks.org/problems/arranging-the-array1131/1
// Time Complexity: O(n)
// Space Complexity: O(n)

public void Rearrange(int[] arr, int n) {
    Queue<Integer> neg = new ArrayDeque<>(); // Queue to store negative numbers
    Queue<Integer> pos = new ArrayDeque<>(); // Queue to store non-negative numbers
    
    // Iterate over the input array
    for (int i = 0; i < n; i++) {
        if (arr[i] < 0)
            neg.offer(arr[i]); // Enqueue negative numbers
        else
            pos.offer(arr[i]); // Enqueue non-negative numbers
    }
    
    int i = 0;
    while (!neg.isEmpty()) {
        arr[i] = neg.poll(); // Dequeue negative numbers and assign them back to the input array
        i++;
    }
    
    while (!pos.isEmpty()) {
        arr[i] = pos.poll(); // Dequeue non-negative numbers and assign them back to the input array
        i++;
    }
}

