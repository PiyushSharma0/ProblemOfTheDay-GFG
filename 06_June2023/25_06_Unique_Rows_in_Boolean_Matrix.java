// Link: https://practice.geeksforgeeks.org/problems/unique-rows-in-boolean-matrix/1
// Time Complexity: O(R * C) where R is the number of rows and C is the number of columns
// Space Complexity: O(R * C) as the HashSet can contain at most R * C elements

import java.util.*;

class GfG {
    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][], int r, int c) {
        // Create an ArrayList to store the unique rows
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        // Create a HashSet to keep track of seen rows
        HashSet<String> set = new HashSet<String>();
        
        // Iterate over each row of the matrix
        for (int i = 0; i < r; i++) {
            // Create a string representation of the current row
            String s = "";
            for (int j = 0; j < c; j++) {
                s += a[i][j];
            }
            
            // Check if the current row is unique (not seen before)
            if (!set.contains(s)) {
                // Add the string representation of the row to the set
                set.add(s);
                
                // Create an ArrayList to store the unique row elements
                ArrayList<Integer> list = new ArrayList<Integer>();
                
                // Add each element of the current row to the ArrayList
                for (int j = 0; j < c; j++) {
                    list.add(a[i][j]);
                }
                
                // Add the ArrayList to the result list
                result.add(list);
            }
        }
        
        // Return the list of unique rows
        return result;
    }
}
