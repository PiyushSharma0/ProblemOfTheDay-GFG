<<<<<<< HEAD
// Link: https://practice.geeksforgeeks.org/problems/frequency-game/1
// Time Complexity: O(n)
// Space Complexity: O(n)

public static int LargButMinFreq(int arr[], int n) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();

    // Count the frequency of each element in the array
    for (int i = 0; i < n; i++) {
        frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
    }

    int largestElement = Integer.MIN_VALUE;
    int minFrequency = Integer.MAX_VALUE;

    // Find the largest element with minimum frequency
    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
        int element = entry.getKey();
        int frequency = entry.getValue();

        if (frequency < minFrequency || (frequency == minFrequency && element > largestElement)) {
            minFrequency = frequency;
            largestElement = element;
        }
    }
    return largestElement;
=======
// Link: https://practice.geeksforgeeks.org/problems/frequency-game/1
// Time Complexity: O(n)
// Space Complexity: O(n)

public static int LargButMinFreq(int arr[], int n) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();

    // Count the frequency of each element in the array
    for (int i = 0; i < n; i++) {
        frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
    }

    int largestElement = Integer.MIN_VALUE;
    int minFrequency = Integer.MAX_VALUE;

    // Find the largest element with minimum frequency
    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
        int element = entry.getKey();
        int frequency = entry.getValue();

        if (frequency < minFrequency || (frequency == minFrequency && element > largestElement)) {
            minFrequency = frequency;
            largestElement = element;
        }
    }
    return largestElement;
>>>>>>> 180277b61981e5710a02aeb4d4ca58318af8dff5
}