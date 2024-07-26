// Link: https://www.geeksforgeeks.org/problems/k-pangrams0909/1
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    boolean kPangram(String str, int k) {
        
        str = str.replaceAll("\\s", "");
        
        if(str.length() < 26) return false;
        if(str.length() >= 26  && k == 25) return true;
        
        int freq[] = new int[26];
        
        for(int i=0; i<str.length(); i++){
            
            char ch = str.charAt(i);
            freq[ch - 'a']++;
        }
        
        int count =0;
        
        for(int i=0; i<freq.length ; i++){
            
            if(freq[i] == 0){
                count++;
            }
        }
        
        if(k >= count){
            return true;
        }
        
        return false;
    }
}