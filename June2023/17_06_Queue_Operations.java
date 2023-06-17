// Link: https://practice.geeksforgeeks.org/problems/queue-operations/1
// Time Complexity: O(n) for findFrequency() and O(1) for insert()
// Space Complexity: O(1)

import java.util.Queue;

class Solution {
    
    // Function to insert element into the queue
    static void insert(Queue<Integer> q, int k){
        q.add(k);
    }
    
    // Function to find frequency of an element
    // and return the frequency of k
    static int findFrequency(Queue<Integer> q, int k){
        int frequency = 0;
        
        // Iterate over the queue and count the occurrences of k
        for (Integer element : q) {
            if (element == k) {
                frequency++;
            }
        }
        
        // If k is not found in the queue, return -1
        if (frequency == 0) {
            return -1;
        }
        
        return frequency;
    }
}