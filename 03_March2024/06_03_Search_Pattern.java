// Link: https://practice.geeksforgeeks.org/problems/search-pattern/0
// Time Complexity: O(n*m)
// Space Complexity: O(1)

class Solution
{
    ArrayList<Integer> search(String pattern, String text)
    {
        ArrayList<Integer> res = new ArrayList<>();
        
        int textLength = text.length();
        int patternLength = pattern.length();
        
        for(int i = 0; i <=  textLength-patternLength; i++){
            if(pattern.equals(text.substring(i, patternLength+i))){
                res.add(i+1);
            }
        }
        
        return res;
    }
}