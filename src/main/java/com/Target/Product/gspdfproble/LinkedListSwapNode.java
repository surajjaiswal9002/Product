package com.Target.Product.gspdfproble;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}


public class LinkedListSwapNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(" Before Swap ");
        printLinkedList(head);
        
        head = swapNode(head);
        
        System.out.println(" After Swap ");
        printLinkedList(head);
    }

    public static void printLinkedList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode swapNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = head.next;
        head.next = swapNode(nextNode.next);
        nextNode.next = head;

        return nextNode;

    }
}
