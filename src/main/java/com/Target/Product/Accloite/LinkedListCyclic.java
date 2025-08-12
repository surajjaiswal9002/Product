package com.Target.Product.Accloite;

public class LinkedListCyclic {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        boolean isTrue = isCyclicLL(head);

        System.out.println(" is Cyclic LinkedList : "+isTrue);
    }

    public static boolean isCyclicLL(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void printLinkedList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
