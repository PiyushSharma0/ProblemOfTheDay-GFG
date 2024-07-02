// Link: https://www.geeksforgeeks.org/problems/linked-list-of-strings-forms-a-palindrome/1
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    public boolean compute(Node root) {
        if(root==null){
            return false;
        }
        StringBuilder st = new StringBuilder();
        while(root!=null){
            st.append(root.data);
            root = root.next;
        }
        
        String org = st.toString();
        String rev = st.reverse().toString();
        
        return org.equals(rev);
    }
}