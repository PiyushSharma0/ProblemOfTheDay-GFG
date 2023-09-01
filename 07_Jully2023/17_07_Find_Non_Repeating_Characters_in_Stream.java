// Link: https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream/0
// Time Complexity: O(n)
//  Space Complexity: O(n)

import java.util.*;

class Solution
{
    public String FirstNonRepeating(String A)
    {
        // HashMap to store the frequency of each character in the input stream
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Queue to maintain the order of appearance of characters in the input stream
        Queue<Character> queue = new LinkedList<>();

        // StringBuilder to store the output
        StringBuilder output = new StringBuilder();

        for (char c : A.toCharArray())
        {
            // Update the frequency of the character
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);

            // Add the character to the queue
            queue.offer(c);

            // Check if the first character in the queue is non-repeating
            while (!queue.isEmpty() && frequencyMap.get(queue.peek()) > 1)
            {
                queue.poll();
            }

            // Append the result to the output StringBuilder
            if (!queue.isEmpty())
            {
                output.append(queue.peek());
            }
            else
            {
                output.append('#');
            }
        }

        return output.toString();
    }
}
