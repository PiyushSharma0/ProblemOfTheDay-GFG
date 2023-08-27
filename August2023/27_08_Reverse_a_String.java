// Link: https://practice.geeksforgeeks.org/problems/reverse-a-string/1
// Time Complexity: O(n) where n is the length of the input string\
// Space Complexity: O(n) where n is the length of the input string

class Reverse
{
    public static String reverseWord(String str)
    {
        // Convert the input string to a character array
        char[] charArray = str.toCharArray();
        
        // Initialize pointers for the start and end of the array
        int start = 0;
        int end = charArray.length - 1;
        
        // Swap characters from the start and end pointers towards the center
        while (start < end)
        {
            // Swap characters at positions start and end
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            
            // Move the pointers towards the center
            start++;
            end--;
        }
        
        // Convert the character array back to a string
        String reversedStr = new String(charArray);
        
        return reversedStr;
    }
}
