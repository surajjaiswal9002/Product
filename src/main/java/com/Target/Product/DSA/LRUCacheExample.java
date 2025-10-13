package com.Target.Product.DSA;

import java.util.HashMap;
import java.util.Map;

//Design a data structure that supports LRU Cache with the following operations:
// get(key) – Retrieve the value of the key if it exists, otherwise return -1.
//put(key, value) – Insert or update the value. If the cache exceeds capacity, remove the least recently used item.


class LRUCache{
	
	class Node{
		int key, value;
		Node prev, next;
		
		Node(int key, int value){
			this.key = key;
			this.value = value;
		}
	}
	
	int capacity;
	Map<Integer, Node> map;
	Node head, tail;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<Integer, LRUCache.Node>();
		
		head = new Node(0, 0);
		tail = new Node(0, 0);
		
		head.next = tail;
		tail.prev = head;
	}
	
	public void insert(Node node) {
		map.put(node.key, node);
		
		node.next = head.next;
		node.prev = head;
		
		head.next.prev = node;
		head.next = node;
	}
	
	
	public void remove(Node node) {
		map.remove(node.key);
		
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	
	public int get(int key){
		if(!map.containsKey(key)) return -1;
		
		Node node = map.get(key);
		remove(node);
		insert(node);
		
		return node.value;
	}
	
	public void put(int key, int value) {
		if(map.containsKey(key)) {
			remove(map.get(key));
		}
		
		if(map.size() == capacity) {
			// remove recent used befor tail
			remove(tail.prev);
		}
		
		insert(new Node(key, value));
	}
}


public class LRUCacheExample {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		
		cache.put(1, 10);
		cache.put(2, 20);
		
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		
		cache.put(3, 30);
		System.out.println(cache.get(3));
		System.out.println(cache.get(1));
	}
}
