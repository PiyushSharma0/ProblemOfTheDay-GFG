// Link: https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1#
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    int longSubarrWthSumDivByK(int a[], int n, int k) {
        // Create an array to store the cumulative sum modulo K
        int[] prefixSumModK = new int[n];

        // Calculate the cumulative sum
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            // Use the modulo operator to prevent overflow
            prefixSumModK[i] = ((sum % k) + k) % k;
        }

        // Create a map to store the index of the first occurrence of a remainder
        HashMap<Integer, Integer> remainderIndexMap = new HashMap<>();

        // Initialize variables to store the maximum length and starting index of subarray
        int maxLength = 0;
        int startIndex = -1;

        for (int i = 0; i < n; i++) {
            if (prefixSumModK[i] == 0) {
                // If the cumulative sum is already divisible by K, update maxLength and startIndex
                maxLength = i + 1;
                startIndex = 0;
            } else {
                // Check if the remainder is already present in the map
                if (!remainderIndexMap.containsKey(prefixSumModK[i])) {
                    // If not present, store the index
                    remainderIndexMap.put(prefixSumModK[i], i);
                } else {
                    // If present, update maxLength if a longer subarray is found
                    int currentLength = i - remainderIndexMap.get(prefixSumModK[i]);
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                        startIndex = remainderIndexMap.get(prefixSumModK[i]) + 1;
                    }
                }
            }
        }

        return maxLength;
    }
}
