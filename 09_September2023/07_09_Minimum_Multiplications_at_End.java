// Link: https://practice.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
// Time Complexity: O(N * M) where N is the number of elements in the array and M is the number of digits in each element
// Space Complexity: O(N * M) where N is the number of elements in the array and M is the number of digits in each element

import java.util.*;

class Solution {
    public int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end) {
            return 0; // Already at the destination
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> memo = new HashMap<>();

        queue.offer(start);
        visited.add(start);
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int num : arr) {
                    int next = (current * num) % 100000;
                    if (next == end) {
                        return steps;
                    }
                    if (!visited.contains(next) && !memo.containsKey(next)) {
                        queue.offer(next);
                        visited.add(next);
                        memo.put(next, steps);
                    }
                }
            }
        }

        return -1; // No way to reach the end
    }
}
