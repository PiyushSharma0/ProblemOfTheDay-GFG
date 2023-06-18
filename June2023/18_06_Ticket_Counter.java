// Link: https://practice.geeksforgeeks.org/problems/ticket-counter/
// Time Complexity: O(1)
// Space Complexity: O(1)

class Solution {
    public int distributeTicket(int N, int K) {
        // Calculate the number of complete rounds of distribution
        int cut = N / (2 * K);
        
        // Calculate the starting position of the last round
        int left = 1 + (cut * K);
        
        // Calculate the remaining number of people after the last complete round
        int right = N - (cut * K);

        // Check conditions to determine the last person to get the ticket
        
        // If there are no remaining people after the last complete round
        if (right < left) {
            return left;
        }
        
        // If the remaining people are within a range of K positions
        if (right - left + 1 <= K) {
            return right;
        } else {
            // If there are more than K remaining people, skip them and return the updated left position
            left += K;
            return left;
        }
    }
}
