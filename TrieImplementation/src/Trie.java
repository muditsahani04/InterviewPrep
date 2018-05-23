
class Trie {

    TrieNode root;
    class TrieNode {
        
        TrieNode[] nodes = null;
        boolean isEndOfWord;
        
        public TrieNode()
        {
            nodes = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode current = root;
        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            if (current.nodes[c-'a'] == null)
            {
                
                TrieNode newNode = new TrieNode();
                current.nodes[c-'a'] = newNode;
                current = newNode;
            }
            else
            {
                current = current.nodes[c-'a'];
            }
        }
        current.isEndOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode current = root;
        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            if (current.nodes[c-'a'] == null)
            	return false;
            else
            {
                current = current.nodes[c-'a'];
            }
        }
        if (current.isEndOfWord)
        	return true;
		return false;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode current = root;
    	int i=0;
    	for(i=0; i<prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            if (current.nodes[c-'a'] == null)
            	return false;
            else
            {
                current = current.nodes[c-'a'];
            }
        }
    	
    	if ( i < prefix.length() )
    		return false;
		return true;
        
    }
}
