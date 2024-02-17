// Link: https://www.geeksforgeeks.org/recamans-sequence/
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution{
    static ArrayList<Integer> recamanSequence(int n) {
       ArrayList<Integer> result = new ArrayList<>();
       HashSet<Integer> set = new HashSet<>();

       result.add(0);
       set.add(0);

       for (int i = 1; i < n; i++) {
           int prev = result.get(i - 1);

           int subtract = prev - i;
           int add = prev + i;

           if (subtract > 0 && !set.contains(subtract)) {
               result.add(subtract);
               set.add(subtract);
           } else {
               result.add(add);
               set.add(add);
           }
       }

       return result;
   }
}