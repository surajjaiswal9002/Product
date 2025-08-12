package com.Target.Product.Accloite;

public class LinkedListSwapPair {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        printLinkedList(head);
        head = swapPair(head);
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


    public static ListNode swapPair(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = head.next;
        head.next = swapPair(nextNode.next);
        nextNode.next = head;

        return nextNode;

    }


}
