// Link: https://practice.geeksforgeeks.org/problems/-matchsticks-game4906/1
// Time Complexity: O(1)
// Space Complexity: O(1)

class Solution {
    static int matchGame(Long N) {
        // If N is divisible by 5, it is impossible for player A to win
        if (N % 5 == 0)
            return -1;
        
        // Otherwise, return the remainder when N is divided by 5
        return (int) (N % 5);
    }
}
