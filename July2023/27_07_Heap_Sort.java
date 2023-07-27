// Link: https://practice.geeksforgeeks.org/problems/heap-sort/1
// Time Complexity: O(nlogn)
// Space Complexity: O(1)

class Solution {
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as the root
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        // If the left child is larger than the root
        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        // If the right child is larger than the largest so far
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // If the largest is not the root, swap the largest with the root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n) {
        // Build the Max Heap
        buildHeap(arr, n);

        // One by one extract elements from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move the current root (largest element) to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
}
