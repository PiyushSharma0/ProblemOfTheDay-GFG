// Link: https://practice.geeksforgeeks.org/problems/camel-case-pattern-matching/0/?track=Java-Collections-ArrayList&batchId=318#
// Time Complexity: O(N * M) where N is the number of words in the dictionary and M is the length of the longest word in the dictionary
// Space Complexity: O(N) where N is the number of words in the dictionary

ArrayList<String> CamelCase(int N, String[] Dictionary, String Pattern) {
    ArrayList<String> arr = new ArrayList<>();

    // Iterate through each word in the dictionary
    for (String s : Dictionary) {
        String str = "";
        
        // Extract uppercase characters from the word
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                str += s.charAt(i);
            }
        }
        
        // Check if the extracted characters match the pattern
        if (str.length() >= Pattern.length() && str.substring(0, Pattern.length()).equals(Pattern)) {
            arr.add(s);
        }
    }

    // If no matches found, add "-1" to the list and return
    if (arr.size() == 0) {
        arr.add("-1");
        return arr;
    }

    // Sort the list in lexicographical order
    Collections.sort(arr);

    // Return the list of matching words
    return arr;
}
