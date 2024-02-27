// Link: https://practice.geeksforgeeks.org/problems/game-with-nos3123/1
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution{  
    // Function for finding maximum and value pair
    public static int[] game_with_number(int arr[], int n) {      
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i] | arr[i + 1];
        }
        
        return arr;
    }
}
