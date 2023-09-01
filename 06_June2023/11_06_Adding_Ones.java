// Link: https://practice.geeksforgeeks.org/problems/adding-ones3628/
// Time Complexity: O(n + k)     where n is the size of the array and k is the number of updates
// Space Complexity: O(n)        where n is the size of the array

public static void update(int a[], int n, int updates[], int k) {
    int[] dx = new int[n];
        
    for (int i = 0; i < k; i++)
        dx[updates[i] - 1]++;
        
    int toadd = 0;
        
    for (int i = 0; i < n; i++) {
        toadd += dx[i];
        a[i] += toadd;
    }
}