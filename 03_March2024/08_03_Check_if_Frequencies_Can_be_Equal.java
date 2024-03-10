// Link: https://practice.geeksforgeeks.org/problems/check-if-frequencies-can-be-equal/0
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    boolean sameFreq(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Map<Integer, Integer> hashMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            min = Math.min(m.getValue(), min);
            max = Math.max(m.getValue(), max);
            hashMap.put(m.getValue(), hashMap.getOrDefault(m.getValue(), 0) + 1);
        }
        if (hashMap.size() > 2)
            return false;
        if (max > min && hashMap.get(max) > 1 && min == 1)
            return true;
        if (max > min && hashMap.get(max) > 1 && min > 1)
            return false;
        if (min == max || max == min + 1)
            return true;
        return false;
    }
}