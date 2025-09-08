package com.Target.Product.gspdfproble;


public class SwapLinkedList {
    public static void main(String[] args) {
        // Create LinkedList: 1 -> 2 -> 3 -> 4
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original List:");
        printList(head);

        // Swap in pairs
        head = swapPairs(head);

        System.out.println("After Swapping in Pairs:");
        printList(head);
    }

    // Swap nodes in pairs
    public static Node swapPairs(Node head) {
        // Dummy node before head (helps in handling edge cases)
        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;

        while (head != null && head.next != null) {
            // Identify nodes
            Node first = head;
            Node second = head.next;

            // Swapping
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Move pointers
            prev = first;
            head = first.next;
        }

        return dummy.next; // new head
    }

    // Print list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}

