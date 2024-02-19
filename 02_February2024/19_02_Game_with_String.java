// Link: https://www.geeksforgeeks.org/problems/game-with-string/0
// Time Complexity: O(n log n)
// Space Complexity: O(n)

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    static int minValue(String s, int k) {
        // Step 1: Count the frequency of each character
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create a max heap to store frequencies in decreasing order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(frequencyMap.values());

        // Step 3: Try removing characters to minimize the value
        while (k > 0 && !maxHeap.isEmpty()) {
            int freq = maxHeap.poll();
            if (freq > 1) {
                maxHeap.offer(freq - 1);
            }
            k--;
        }

        // Step 4: Calculate the minimum value
        int minValue = 0;
        while (!maxHeap.isEmpty()) {
            int freq = maxHeap.poll();
            minValue += freq * freq;
        }

        return minValue;
    }
}
