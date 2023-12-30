// Link: https://www.geeksforgeeks.org/problems/winner-of-an-election-where-votes-are-represented-as-candidate-names-1587115621/1
// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.HashMap;
import java.util.Map;

class Solution
{
    // Function to return the name of the candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // HashMap to store the count of votes for each candidate.
        Map<String, Integer> voteCount = new HashMap<>();

        // Iterate through the array and count the votes.
        for (String candidate : arr) {
            voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        }

        // Variables to store the candidate with maximum votes and the maximum count.
        String winner = "";
        int maxVotes = 0;

        // Iterate through the HashMap to find the winner.
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            String candidate = entry.getKey();
            int votes = entry.getValue();

            // Check if the current candidate has more votes than the current maximum.
            // If tied, choose lexicographically smaller candidate.
            if (votes > maxVotes || (votes == maxVotes && candidate.compareTo(winner) < 0)) {
                winner = candidate;
                maxVotes = votes;
            }
        }

        // Return the winner.
        return new String[]{winner, String.valueOf(maxVotes)};
    }
}
