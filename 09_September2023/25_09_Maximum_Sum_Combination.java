// Link: https://practice.geeksforgeeks.org/problems/maximum-sum-combination/
// Time Complexity: O(N^2)
// Space Complexity: O(K)

import java.util.*;

class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // Create a priority queue to store the K largest sum combinations
        PriorityQueue<Integer> p = new PriorityQueue<>();
        
        // Create a list to store the final result
        List<Integer> list = new ArrayList<>();
        
        // Sort arrays A and B in ascending order
        Arrays.sort(A);
        Arrays.sort(B);
        
        // Iterate over the last K elements of both arrays A and B
        for (int i = N - 1; i > N - K - 1; i--) {
            for (int j = N - 1; j > N - K - 1; j--) {
                // Calculate the sum of elements from A and B
                int sum = A[i] + B[j];
                
                // If the priority queue is not full (size < K), add the sum
                if (p.size() < K) {
                    p.add(sum);
                } else {
                    // If the priority queue is full, compare the smallest element
                    // (at the front of the queue) with the current sum
                    // If the smallest element is smaller than the sum, replace it
                    // with the current sum
                    if (p.peek() < sum) {
                        p.poll(); // Remove the smallest element
                        p.add(sum); // Add the current sum
                    } else {
                        break; // If the current sum is smaller than the smallest element, no need to check further
                    }
                }
            }
        }
        
        // Pop elements from the priority queue and add them to the result list
        while (!p.isEmpty()) {
            list.add(0, p.poll()); // Using add(0, element) to add elements at the beginning
        }
        
        return list; // Return the list of K largest sum combinations in non-increasing order
    }
}
