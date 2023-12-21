// Link: https://www.geeksforgeeks.org/problems/candy/1
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    static int minCandy(int N, int ratings[]) {
        if (N <= 1) {
            return N;
        }

        int[] candies = new int[N];
        
        // Initialize candies for each child to 1
        Arrays.fill(candies, 1);

        // Traverse the ratings array from left to right
        for (int i = 1; i < N; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Traverse the ratings array from right to left
        for (int i = N - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Calculate the total number of candies needed
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}
