class Solution {
    // This function checks if it's possible to divide the sum of an array
    // into three equal parts by calculating the modulo of each element and
    // then checking if the sum of those modulo values is divisible by 3.
    // If it is divisible by 3, the function returns true; otherwise, it returns false.
    public int isPossible(int N, int[] arr) {
        int sum = 0;

        // Calculate the sum of the modulo values of the array elements.
        for (int i = 0; i < N; i++) {
            sum += arr[i] % 3;
        }

        // Check if the sum of modulo values is divisible by 3.
        if (sum % 3 == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}