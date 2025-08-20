package com.Target.Product.DSA;

public class ReverseLinkedList {
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		
		System.out.println(" Input : ");
		display(head);
		ListNode ans = reverseLinkedList(head);
		System.out.println(" Output : ");
		display(ans);
	}
	
	public static ListNode reverseLinkedList(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		
		while(curr != null) {
			next = curr.next;  // save to next node
			curr.next = prev;  // reverse the link
			prev = curr;       // move prev forward
			curr = next;	// move curr forward
		}
		return prev;
	}
	
	public static void display(ListNode head) {
		ListNode curr  = head;
		
		while(curr != null) {
			System.out.print(" "+curr.data);
			curr = curr.next;
		}
		System.out.println();
	}
}
