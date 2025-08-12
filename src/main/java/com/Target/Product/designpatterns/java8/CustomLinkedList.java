package com.Target.Product.designpatterns.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Player {
    private int id;
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String name;

    // constructor
    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

  

    // getter
    public String getName() {
        return name;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    // toString
    public String toString() {
        return "Player = { " + " player id = " + id + ", player name " + name + "}";
    }


    

}

class Node {
    Player player;
    Node next;

    Node(Player player) {
        this.player = player;
        this.next = null;
    }
}


class PlayerLinkedList {
    private Node head;

    // add
    public void add(Player player) {
        Node newNode = new Node(player);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }
    // delete
    public void delete(int id) {
        if (head == null) {
            return;
        }

        if (head.player.getId() == id) {
            head = head.next;
            return;
        }

        Node curr = head;
        while (curr.next.player.getId() == id) {
            curr.next = curr.next.next;
            return;
        }
        curr = curr.next;

    }

    // display
    public void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.player + " -->");
            curr = curr.next;
        }
        System.out.println("null");
    }


}


public class CustomLinkedList {
    public static void main(String[] args) {
        PlayerLinkedList list = new PlayerLinkedList();

        Player p1 = new Player(1, "virat");
        Player p2 = new Player(2, "rohit");

        list.add(p1);
        list.add(p2);
        System.out.println(" After adding players ");
        list.display();

        list.delete(2);
        System.out.println(" After delete players ");
        list.display();


        Map<Player, String> map = new HashMap<>();
        map.put(p1, "Odisha");

        System.out.println(map);
    }

}
