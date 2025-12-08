t6package com.Target.Product.LinkedList;

import java.util.*;

class LRUCache{
	private int capacity;
	private Map<Integer, Node> cache;
	private Node head, tail;
	
	LRUCache(int capacity){
		this.capacity = capacity;
		this.cache = new HashMap<>();
		
		head = new Node(0,0); // dummy head
		tail = new Node(0, 0); // dummy head
		head.next = tail;
		tail.prev = head;
	}
	
	
	//get
	public int get(int n) {
		return -12;
	}
	
	// put
	
	//remove
	
	// insertFirst
	
}



public class LRUCacheExample{

	public static void main(String[] args) {
		
		
	}

}
