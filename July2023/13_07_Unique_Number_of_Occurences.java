// Link: https://practice.geeksforgeeks.org/problems/unique-frequencies-of-not/1
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public static boolean isFrequencyUnique(int n, int[] arr) {
        // Create a HashMap to store the frequency of each element
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element in the array
        for (int num : arr) {
            // If the element is already in the HashMap, increment its frequency by 1
            // Otherwise, add the element to the HashMap with a frequency of 1
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a HashSet to store the unique frequencies
        HashSet<Integer> uniqueFrequencies = new HashSet<>(frequencyMap.values());

        // If the size of the HashSet is equal to the size of the HashMap,
        // it means all frequencies are unique
        // Return true; otherwise, return false
        return uniqueFrequencies.size() == frequencyMap.size();
    }
}
