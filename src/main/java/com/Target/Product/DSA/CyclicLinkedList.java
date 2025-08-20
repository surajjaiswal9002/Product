package com.Target.Product.DSA;

public class CyclicLinkedList {
	public static void main(String[] args) {
		
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		head.next.next.next.next = head.next;
		
		boolean isTrue = isCyclic(head);
		System.out.println(" Is Cyclic "+isTrue);
	}
	
	// tc - O(n) and sc -  O(1)
	public static boolean isCyclic(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null || fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
			    return true;
			}
		}
		
		return false;
	}
}
