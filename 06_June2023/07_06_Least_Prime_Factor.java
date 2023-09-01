// Link: https://practice.geeksforgeeks.org/problems/least-prime-factor/0
// Time Complexity: O(nloglogn)
// Space complexity: O(n)

public int[] leastPrimeFactor(int n) {
    int[] lpf = new int[n + 1];

    for (int num = 2; num <= n; num++) {
        if (lpf[num] == 0) {
            lpf[num] = num;
            for (int i = num * num; i <= n; i += num) {
                if (lpf[i] == 0) {
                    lpf[i] = num;
                }
            }
        }
    }

    lpf[1] = 1; // Set least prime factor of 1 as 1

    return lpf;
}