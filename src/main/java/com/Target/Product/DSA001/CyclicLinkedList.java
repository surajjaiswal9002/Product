package com.Target.Product.DSA001;


public class CyclicLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		head.next.next.next.next = head.next;
		
		boolean isCyclic = hasCyclic(head);
		System.out.println(isCyclic);
		ListNode detectCyclicRes = detectCyclic(head);
		System.out.println(detectCyclicRes.data);
		
		
	}
	 
	// tc - O(n) and sc - O(1)
	public static boolean hasCyclic(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				return true;
			}
		}
		
		return false;
	}
	
	
	// detectCyclic
	public static ListNode detectCyclic(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				// Step 2: Find entry point
				ListNode entry = head;
				while(entry != slow) {
					entry = entry.next;
					slow = slow.next;
				}
				
				return entry;
			}
		}
		
		return null;
	}
}
