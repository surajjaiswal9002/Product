package com.Target.Product.DSA;

public class SwapLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		printLinkedList(head);
		ListNode res = swapLinkedList(head);
		printLinkedList(res);
	}
	
	// Tc = O(n) and sc - O(n)
	public static ListNode swapLinkedList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode nextNode = head.next;
		head.next = swapLinkedList(nextNode.next);
		nextNode.next = head;
		
		return nextNode;
	}
	
	public static void printLinkedList(ListNode head) {
		ListNode curr = head;
		
		while(curr != null) {
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
		
		System.out.println();
	}
}
