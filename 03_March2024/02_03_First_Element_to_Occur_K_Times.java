// Link: https://practice.geeksforgeeks.org/problems/first-element-to-occur-k-times/0
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution
{
    public int firstElementKTime(int n, int k, int[] a) { 
         LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
         for(int i:a){
         if(map.containsKey(i)){
             map.put(i,map.get(i)+1);
             if(map.get(i)==k){
                 return i;
             }
         }else{
             map.put(i,1);
         }
         }
        
         return -1;
    } 
}