// Link: https://practice.geeksforgeeks.org/problems/fraction-pairs-with-sum-1/
// Time Complexity: O(N)
// Space Complexity: O(N)

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public int countFractions(int n, int[] num, int[] den) {
        // Create a map to store simplified rational numbers and their frequencies
        Map<Pair, Integer> mp = new HashMap<>();
        
        // Process each fraction and store it in the map
        for (int i = 0; i < n; ++i) {
            int gcd = gcd(num[i], den[i]); // Calculate the greatest common divisor
            // Store the simplified fraction in the map along with its frequency
            mp.put(new Pair(num[i] / gcd, den[i] / gcd), mp.getOrDefault(new Pair(num[i] / gcd, den[i] / gcd), 0) + 1);
        }

        int out = 0; // Initialize the count of pairs
        
        // Iterate through the map entries to find pairs of fractions
        for (Map.Entry<Pair, Integer> entry : mp.entrySet()) {
            int nume = entry.getKey().first;
            int deno = entry.getKey().second;
            int cnt = entry.getValue();
            
            if (cnt > 0) {
                int newNume = deno - nume; // Calculate the complement numerator
                if (nume == newNume) {
                    out += (cnt * (cnt - 1)) / 2; // Add pairs for identical fractions
                } else if (mp.containsKey(new Pair(newNume, deno))) {
                    out += cnt * mp.get(new Pair(newNume, deno)); // Add pairs for complement fractions
                    mp.put(new Pair(newNume, deno), 0); // Mark complement fraction as used
                }
            }
        }
        return out; // Return the total count of pairs
    }
    
    // Custom Pair class to represent pairs of integers (numerator and denominator)
    class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
    
    // Function to calculate the greatest common divisor
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
