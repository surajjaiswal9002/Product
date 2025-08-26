package com.Target.Product.LinkedList;

public class LinkedList {
	
	private Node head;
	private Node tail;
	private int length;
	
	public class Node {
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
			this.next = next;
		}

	}

	
	public LinkedList(int data) {
		Node newNode = new Node(data);
		this.head = newNode;
		this.tail = newNode;
		this.length = 1;
	}
	
	public Node getHead() {
		return head;
	}
	
	public Node getTail() {
		return tail;
	}
	
	public void printLinkedList() {
		Node curr = head;
		
		while(curr != null) {
			System.out.print(curr.data+" -> ");
			curr = curr.next;
			
		}
		System.out.println("null");
	}
	
	
	public void printAll() {
		if(length == 0) {
			System.out.println(" Head: null");
			System.out.println(" Tail: null");
		}else {
			System.out.println(" Head: "+head.data);
			System.out.println(" Tail: "+tail.data);
		}
		
		System.out.println("Length: "+length);
		System.out.println("\nLinked List ");
		if(length == 0) {
			System.out.println(" enpty ");
		}else {
			printLinkedList();
		}
		
	}
	
	public void append(int data) {
		Node newNode = new Node(data);
		if(data == 0) {
			head = newNode;
			tail = newNode;
		}else {
			tail.next = newNode;
			tail = newNode;
		}
		length++;	
	}
	
	public Node removeLast() {
		if(length == 0) return null;
		Node temp = head;
		Node pre = head;
		
		while(temp.next != null) {
			pre = temp;
			temp = temp.next;
			
		}
		tail = pre;
		tail.next = null;
		length--;
		if(length == 0) {
			head = null;
			tail = null;
		}
		
		return temp;
		
	}
	
	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList(10);
		ll.append(20);
		ll.append(30);
		ll.append(40);
		ll.append(50);
		
		ll.printLinkedList();
		ll.removeLast();
		ll.printLinkedList();
		
		
	}
	
}
