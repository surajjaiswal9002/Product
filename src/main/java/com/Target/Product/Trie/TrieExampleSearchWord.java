package com.Target.Product.Trie;

import java.util.HashMap;
import java.util.Map;

import com._0.Billions.p1.findDifference;

import java.util.*;

class TrieNode{
	Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	boolean isEndWord = false;
}

class Trie{
	
	private  TrieNode root;
	
	Trie(){
		root = new TrieNode();
	}
	
	
	//insert - tc - O(n)
	public void insert(String word) {
		TrieNode current = root;
		for(char ch : word.toCharArray()) {
			current = current.children.computeIfAbsent(ch, c -> new TrieNode());
		}
		
		current.isEndWord = true;
	}
	
	//search - O(n)
	public boolean search(String word) {
		TrieNode node = findPrefix(word);
		
		return node != null && node.isEndWord;
	}
	
	
	// startwith - O(n)
	public boolean startWith(String word) {
		return findPrefix(word) != null;
	}
	
	//getWordWithprefix - o(n*L) and O(k.n)
	public List<String> getWordWithPrifix(String prefix){
		TrieNode node = findPrefix(prefix);
		List<String> result = new ArrayList<>();
		if(node != null) {
			collectWordPrefix(node, new StringBuilder(prefix), result);
		}
		
		return result;
	}
	
	// Helper -- findPrefix
	public TrieNode findPrefix(String prefix) {
		TrieNode current = root;
		for(char ch : prefix.toCharArray()) {
			if(!current.children.containsKey(ch)) {
				return null;
			}
			
			current = current.children.get(ch);
		}
		
		return current;
	}
	
	//collectWordPrefix
	public void collectWordPrefix(TrieNode node, StringBuilder prefix, List<String> result) {
		if(node.isEndWord) {
			result.add(prefix.toString());
		}
		
		for(Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
			prefix.append(entry.getKey());
			collectWordPrefix(entry.getValue(), prefix, result);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}
}



public class TrieExampleSearchWord {
	public static void main(String[] args) {
		Trie trie = new Trie();
		
		trie.insert("apple");
		trie.insert("application");
		trie.insert("applates");
		trie.insert("cat");
		trie.insert("ball");
		
		String prefix = "app";
		
		System.out.println(trie.startWith("app"));
		List<String> list = trie.getWordWithPrifix(prefix);
		
		System.out.println("Word of Prifix '"+prefix+"' : "+list);
	}
}
