// Link: https://practice.geeksforgeeks.org/problems/insert-and-search-in-a-trie/0
// Time Complexity: O(N) for insert and search
// Space Complexity: O(N) for insert and search

class TrieNode
{
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
    TrieNode()
    {
        isEndOfWord = false;
        for(int i = 0; i < 26;i++)
        {
            children[i] = null;
        }
    }
}

class Solution{
    static void insert(TrieNode root, String key)
    {
        // code here
        TrieNode cur = root;
        for(int i = 0; i < key.length();i++)
        {
            int index = key.charAt(i) - 'a';
            if(cur.children[index] == null)
            {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isEndOfWord = true;
    }
    static boolean search(TrieNode root, String key)
    {
        // code here
        TrieNode cur = root;
        for(int i = 0; i < key.length();i++)
        {
            int index = key.charAt(i) - 'a';
            if(cur.children[index] == null)
            {
                return false;
            }
            cur = cur.children[index];
        }
        return cur.isEndOfWord;
    }
}