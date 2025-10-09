package com.Target.Product.DSA002;

import java.util.HashMap;
import java.util.Map;

class LFUCache{
	
	class Node{
		int key, value;
		Node prev, next;
		
		Node(int k, int v){
			this.key = k;
			this.value = v;
		}
	}
	
	int capicity;
	Map<Integer, Node> map;
	Node head, tail;
	
	public LFUCache(int capicity) {
		this.capicity = capicity;
		this.map = new HashMap<Integer, LFUCache.Node>();
		
		head = new Node(0, 0);
		tail = new Node(0, 0);
		
		head.next = tail;
		tail.prev = head;
	}
	
	
	public void put(int key, int value) {
		if(map.containsKey(key)) {
			remove(map.get(key));
		}
		
		if(map.size() == capicity) {
			remove(tail.prev);
		}
		
		insert(new Node(key, value));
	}
	
	public void insert(Node node) {
		map.put(node.key, node);
		
		node.next = head.next;
		node.prev = head;
		
		head.next.prev = node;
		head.next = node;
	}


	private void remove(Node node) {
		map.remove(node.key);
		
		node.prev.next = node.next;
		node.next.prev = node.prev;
		
	}
	
	public int get(int k) {
		if(!map.containsKey(k)) return -1;
		
		Node temp = map.get(k);
		remove(temp);
		insert(temp);
		
		return temp.value;
	}
	
	
}


public class LeastFrequentUsed {
	public static void main(String[] args) {
		LFUCache cache = new LFUCache(2);
		
		cache.put(1, 1);
		cache.put(2, 2);
		
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		cache.put(3, 3);
		System.out.println(cache.get(1));
	}
}
