// Link: https://practice.geeksforgeeks.org/problems/largest-number-possible/
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution{
    static String findLargest(int N, int S){
        // Check if it's impossible to create the number
        if (S > 9 * N || (S == 0 && N > 1)) {
            return "-1";
        }
        
        StringBuilder result = new StringBuilder();
        
        // Construct the largest number from left to right
        for (int i = 0; i < N; i++) {
            if (S >= 9) {
                result.append('9');
                S -= 9;
            } else {
                result.append((char)(S + '0'));
                S = 0;
            }
        }
        
        return result.toString();
    }
}
