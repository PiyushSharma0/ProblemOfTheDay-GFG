// Link: https://www.geeksforgeeks.org/problems/shortest-prime-path--141631/1
// Time Complexity: O(10000 * 4 * 10) = O(400000) = O(1) (Since 10000 is the maximum number and we are changing each digit of the number and checking if it is prime or not)
// Space Complexity: O(10000) = O(1) (Since 10000 is the maximum number and we are using a boolean array to mark the visited numbers)


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    int solve(int num1, int num2) {
        if (num1 == num2) {
            return 0; // Same number, no need to change anything
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];

        queue.offer(num1);
        visited[num1] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == num2) {
                    return steps; // Found the shortest path
                }

                // Change each digit and check if the new number is prime
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k <= 9; k++) {
                        if (j == 0 && k == 0) {
                            continue; // Avoid leading zeros
                        }

                        int newNumber = changeDigit(current, j, k);

                        if (!visited[newNumber] && isPrime(newNumber)) {
                            queue.offer(newNumber);
                            visited[newNumber] = true;
                        }
                    }
                }
            }

            steps++;
        }

        return -1; // If no path is found
    }

    private int changeDigit(int number, int position, int newDigit) {
        int[] digits = new int[4];

        for (int i = 3; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        digits[position] = newDigit;

        int newNumber = 0;
        for (int digit : digits) {
            newNumber = newNumber * 10 + digit;
        }

        return newNumber;
    }
}
