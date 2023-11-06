// Link: https://www.geeksforgeeks.org/problems/top-k-frequent-elements-in-array/1
// Time Complexity: O(nlogn)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public int[] topK(int[] nums, int k) {
        // Create a frequency map to store the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a max heap (PriorityQueue) based on frequency and value
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
            int freqCompare = Integer.compare(frequencyMap.get(b), frequencyMap.get(a));
            if (freqCompare != 0) {
                return freqCompare;
            } else {
                return Integer.compare(b, a); // If frequencies are the same, prioritize larger number
            }
        });

        // Add all unique elements to the max heap
        for (int num : frequencyMap.keySet()) {
            maxHeap.add(num);
        }

        // Get the top k elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}