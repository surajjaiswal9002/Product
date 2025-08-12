package com.gs.practice.customLinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// default Player Class
class Player {
    private int id;
    private String name;

    // constructor
    Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // getter of id
    public int getId() {
        return this.id;
    }
    // getter of name
    public String getName() {
        return this.name;
    }

    // toString
    @Override
    public String toString() {
        return "Player = {" + "id = " + id + ", name = " + name + "}";
    }


    // hashcode
   @Override
   public int hashCode(){
        return Objects.hash(id, name);
   }


   // equals method
   @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != getClass()) return false;
        Player that = (Player) o;
        return that.id == id && Objects.equals(that.name, name);
   }
}

// Node class
class Node {
    Player player;
    Node next;

    public Node(Player player) {
        this.player = player;
        this.next = null;
    }


}


class PlayerLinkedLists {
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

    // remove/delete player with id
    public void delete(int playerId) {
        if (head == null) {
            return;
        }

        if (head.player.getId() == playerId) {
            head = head.next;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            if (curr.next.player.getId() == playerId) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    // display
    public void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.player + " --> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

}


public class CustomLinkedList {
    public static void main(String[] args) {
        PlayerLinkedLists list = new PlayerLinkedLists();

        Player p1 = new Player(1, "abhi");
        Player p2 = new Player(2, "sourabh");

        list.add(p1);
        list.add(p2);
        System.out.println(" After adding");
        list.display();

        list.delete(1);
        System.out.println(" After delete");
        list.display();


        // using player as key in map of state
        Map<Player, String> map = new HashMap<>();
        map.put(p2, "Odisha");

        map.put(p2, "UP");

        System.out.println("Contains p2 as key? " + map.containsKey(p2));
        System.out.println("Value for p2: " + map.get(p2));
    }
}

