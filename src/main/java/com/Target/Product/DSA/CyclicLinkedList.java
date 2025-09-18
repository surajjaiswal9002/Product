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
		
		 // Remove cycle
        removeCycle(head);

        // Check again
        System.out.println("Cycle present after removal? " + isCyclic(head));

        // Print list
        printList(head);

		
	}
	
	// tc - O(n) and sc -  O(1)
	public static boolean isCyclic(ListNode head) {
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
	
	// Remove cycle if present
	public static void removeCycle(ListNode head) {
	    ListNode slow = head;
	    ListNode fast = head;

	    // Step 1: Detect cycle
	    while (fast != null && fast.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;

	        if (slow == fast) { // cycle found
	            break;
	        }
	    }

	    // No cycle
	    if (fast == null || fast.next == null) return;

	    // Step 2: Find start of cycle
	    slow = head;
	    while (slow != fast) {
	        slow = slow.next;
	        fast = fast.next;
	    }

	    // Step 3: Find the last node in the cycle
	    ListNode lastNode= slow;
	    while (lastNode.next != slow) {
	        lastNode = lastNode.next;
	    }

	    // Step 4: Break the cycle
	    lastNode.next = null;
	}
	
	 // Utility: Print linked list (safe after removing cycle)
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

}
