package tries;

import java.util.HashMap;

// TC for finding the longest prefix is O(n)
public class LongestCommonPrefix {

	Trie trie;
	
	public LongestCommonPrefix(Trie trie) {
		this.trie = trie;
	}
	
	public String longestCommonPrefix(String input) {
		StringBuilder result = new StringBuilder();
		int length = input.length();
		
		TrieNode crawl = trie.root;
		
		for (int level=0;level<length;level++) {
			
			char ch = input.charAt(level);
			
			if (crawl.children.containsKey(ch)) {
				result.append(ch);
				crawl = crawl.children.get(ch); // go to the next node
			} else {
				return result.toString();
			}
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		
		Trie dict = new Trie();
		dict.insert("are");
        dict.insert("area");
        dict.insert("base");
        dict.insert("cat");
        dict.insert("cater");        
        dict.insert("basement");	
        
        LongestCommonPrefix lcp = new LongestCommonPrefix(dict);
        System.out.println("Dictionary created successfully !!");
        
        String input = "caterer";
        System.out.print(input + ":   ");
        System.out.println(lcp.longestCommonPrefix(input)); 
        
        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(lcp.longestCommonPrefix(input)); 
        
        input = "are";
        System.out.print(input + ":   ");
        System.out.println(lcp.longestCommonPrefix(input)); 
        
        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(lcp.longestCommonPrefix(input)); 
        
	}

}

class TrieNode {
	public char value;
	public HashMap<Character, TrieNode> children;
	public boolean isEnd;
	
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
		isEnd = false;
	}
	
	public TrieNode(char ch) {
		value = ch;
		children = new HashMap<Character, TrieNode>();
		isEnd = false;
	}
}

class Trie {
	
	TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		int length = word.length();
		TrieNode crawl = root;
		
		for (int level=0;level<length;level++) {
			
			HashMap<Character, TrieNode> children = crawl.children;
			char ch = word.charAt(level);
			
			if (children.containsKey(ch)) { // If child is there 
				crawl = children.get(ch);
			} else {
				TrieNode newNode = new TrieNode(ch);
				children.put(ch, newNode);
				crawl = newNode;
			}
			
		}
		
		// mark at the end that it is a word
		crawl.isEnd = true;
	}
}
