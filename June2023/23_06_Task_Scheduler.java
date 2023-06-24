// Link: https://practice.geeksforgeeks.org/problems/task-scheduler/1
// Time Complexity: O(N)
// Space Complexity: O(1)

import java.util.Arrays;

class Solution {
    static int leastInterval(int N, int K, char tasks[]) {
        int[] frequencies = new int[26]; // Array to store the frequencies of each task
        
        for (char task : tasks) {
            frequencies[task - 'A']++; // Increment the frequency of the corresponding task
        }
        
        Arrays.sort(frequencies); // Sort the frequencies in ascending order
        
        int maxFreq = frequencies[25]; // Get the maximum frequency
        int idleTime = (maxFreq - 1) * K; // Calculate the idle time based on the maximum frequency
        
        for (int i = 24; i >= 0 && frequencies[i] > 0; i--) {
            idleTime -= Math.min(maxFreq - 1, frequencies[i]); // Subtract the minimum between maxFreq - 1 and the frequency of the task
        }
        
        idleTime = Math.max(0, idleTime); // Idle time cannot be negative
        
        return tasks.length + idleTime; // Total time required is the sum of task length and idle time
    }
}