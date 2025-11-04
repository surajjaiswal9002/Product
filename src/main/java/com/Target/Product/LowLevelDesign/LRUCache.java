package com.Target.Product.LowLevelDesign;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
		
	public class Node{
		int key , value;
		Node prev , next;
		
		Node(int key, int value){
			this.key = key;
			this.value = value;
		}
	}
	
	int capacity;
	Map<Integer, Node> map;
	Node head, tail;
	
	LRUCache(int capacity){
		this.capacity = capacity;
		this.map = new HashMap<Integer, LRUCache.Node>();
		this.head = new Node(0, 0);
		this.tail = new Node(0, 0); 
		
		head.next = tail;
		tail.prev = head;
	}
	
	public void remove(Node node) {
		map.remove(node.key);
		
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	public void insert(Node node) {
		map.put(node.key, node);
		
		node.next = head.next;
		node.prev = head;
		
		head.next.prev = node;
		head.next = node;
		
	}
	
	public void put(int key, int value) {
		if(map.containsKey(key)) {
			remove(map.get(key));
		}
		
		if(map.size() == capacity) {
			remove(tail.prev);
		}
		
		insert(new Node(key, value));
	}
	
	public int get(int key) {
		if(!map.containsKey(key)) return -1;
		
		Node temp = map.get(key);
		remove(temp);
		insert(temp);
		
		return temp.value;
	}
	
	public void getAllValue() {
		System.out.println(" LRU Cache data : ");
		for(Map.Entry<Integer, LRUCache.Node> entities : map.entrySet()) {
			System.out.println(entities.getKey()+" , "+entities.getValue().value);
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		
		cache.put(1, 10);
		cache.put(2, 20);
		
		cache.getAllValue();
		System.out.println("\n get 2 -> "+cache.get(2));
		cache.getAllValue();
		cache.put(3, 30);
		cache.getAllValue();
		System.out.println("\n get 2 -> "+cache.get(2));
		cache.put(4, 40);
		cache.getAllValue();
	}
	
}
