// Link: https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array/0
// Time Complexity: O(nlogn)
// Space Complexity: O(n)

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    String printLargest(int n, String[] arr) {
        // Custom comparator to compare strings for sorting
        Comparator<String> customComparator = (a, b) -> (b + a).compareTo(a + b);

        // Sort the array using the custom comparator
        Arrays.sort(arr, customComparator);

        // Concatenate the sorted strings to get the largest number
        StringBuilder result = new StringBuilder();
        for (String str : arr) {
            result.append(str);
        }

        // Handle leading zeros case
        if (result.charAt(0) == '0') {
            return "0";
        }

        return result.toString();
    }
}
