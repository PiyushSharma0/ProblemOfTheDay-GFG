// Link: https://practice.geeksforgeeks.org/problems/chinky-and-diamonds3340/
// Time Complexity: O(K log N), where K is the given time limit and N is the number of bags
// Space Complexity: O(N), where N is the number of bags


class Solution {
    public long maxDiamonds(int[] A, int N, int K) {
        // Create a max heap using a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        // Add the diamond counts of bags to the priority queue
        for (int i = 0; i < N; i++) {
            pq.offer(A[i]);
        }
        
        long ans = 0; // Variable to store the total number of diamonds collected
        
        // Drop bags within the given time limit
        while (K > 0 && !pq.isEmpty()) {
            int cur = pq.poll(); // Retrieve the bag with the maximum number of diamonds
            
            ans += cur; // Add the diamonds from the current bag to the total
            
            if (cur > 1) {
                // Split the bag into two halves and add it back to the priority queue
                pq.offer(cur / 2);
            }
            
            K--; // Decrement the time limit
        }
        
        return ans; // Return the total number of diamonds collected
    }
}
