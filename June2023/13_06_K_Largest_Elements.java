// Link: https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1
// Time Complexity: O(nlogk) where n is the size of the array and k is the number of largest elements to be returned
// Space Complexity: O(k) where k is the number of largest elements to be returned

class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        // Create a min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the first K elements to the min heap
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        // Iterate over the remaining elements
        for (int i = k; i < n; i++) {
            // If the current element is larger than the root of the min heap,
            // remove the root and add the current element to the min heap
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        // Create an array to store the K largest elements
        int[] kLargestArr = new int[k];

        // Extract the K largest elements from the min heap in decreasing order
        for (int i = k - 1; i >= 0; i--) {
            kLargestArr[i] = minHeap.poll();
        }

        return kLargestArr;
    }
}