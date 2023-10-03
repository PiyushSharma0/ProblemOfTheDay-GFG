// Link: https://practice.geeksforgeeks.org/problems/roman-number-to-integer3201/1
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.HashMap;

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        // Create a HashMap to store the values of Roman numerals
        HashMap<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        // Iterate through the Roman numeral string from right to left
        for (int i = str.length() - 1; i >= 0; i--) {
            char currentChar = str.charAt(i);
            int currentValue = romanValues.get(currentChar);

            // If the current value is less than the previous value, subtract it
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }
}