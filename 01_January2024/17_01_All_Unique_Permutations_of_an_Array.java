// Link: https://practice.geeksforgeeks.org/problems/all-unique-permutations-of-an-array/1
// Time Complexity: O(N * N!)
// Space Complexity: O(N * N!)

class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
       ArrayList<ArrayList<Integer>> result = new ArrayList<>();
       ArrayList<Integer> currentPermutation = new ArrayList<>();
       boolean[] used = new boolean[n];

       // Sorting the input array to generate permutations in sorted order
       Collections.sort(arr);

       generatePermutations(arr, n, currentPermutation, used, result);

       return result;
   }

   static void generatePermutations(ArrayList<Integer> arr, int n, ArrayList<Integer> currentPermutation,
                                    boolean[] used, ArrayList<ArrayList<Integer>> result) {
       if (currentPermutation.size() == n) {
           result.add(new ArrayList<>(currentPermutation));
           return;
       }

       for (int i = 0; i < n; i++) {
           // Skip the element if it is already used
           if (used[i]) {
               continue;
           }

           // Skip duplicates to ensure uniqueness
           if (i > 0 && arr.get(i).equals(arr.get(i - 1)) && !used[i - 1]) {
               continue;
           }

           currentPermutation.add(arr.get(i));
           used[i] = true;

           generatePermutations(arr, n, currentPermutation, used, result);

           currentPermutation.remove(currentPermutation.size() - 1);
           used[i] = false;
       }
   }
};