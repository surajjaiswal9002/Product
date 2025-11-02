package com.Target.Product.DSA;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Player{
	int id;
	String name;
	
	// getter
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	// setter
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	// constructor
	Player(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	// toString
	public String toString() {
		return "Player : { id : "+id+", name : "+name+" }";
	}
	// hashcode
	public int hashcode() {
		return Objects.hash(id, name);
	}
	// equals
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || o.getClass() != getClass()) return false;
		Player that = (Player) o;
		return that.id == id && Objects.equals(that.name, name);
	}
}


class Node{
	
	// varibale assign
	Player player;
	Node next;
	
	// constructor
	Node(Player player){
		this.player = player;
		this.next = null;
	}
}

public class CustomLinkedList {
	private Node head;
	
	//add
	public void add(Player player) {
		Node newNode = new Node(player);
		if(head == null) {
			head = newNode;
		}else {
			Node curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			curr.next = newNode;
		}
	}
	// remove
	public void remove(int playerId) {
		if(head == null) return;
		
		if(playerId == head.player.getId()) {
			head = head.next;
			return;
		}
		
		Node curr = head;
		while(curr.next != null) {
			if(curr.next.player.getId() == playerId) {
				curr.next = curr.next.next;
				return;
			}
			curr = curr.next;
		}
	}
	// display
	public void display() {
		Node curr = head;
		
		while(curr != null) {
			System.out.print(" Node "+curr.player);
			curr = curr.next;
		}
		
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		CustomLinkedList ll = new CustomLinkedList();
		
		Player p1 = new Player(1, "suraj");
		Player p2 = new Player(2, "Sameer");
		
		ll.add(p1);
		ll.add(p2);
		System.out.println(" After Add -- ");
		ll.display();
		
		// Remmove
		ll.remove(2);
		System.out.println(" After delete -- ");
		ll.display();
		
		// Using Player key in map state
		Map<Player, String> map = new HashMap<Player, String>();
		map.put(p1, "Odisha");
		map.put(p1, "Banglore");
		
		System.out.println(map);
		System.out.println("Contains p2 as key? " + map.containsKey(p2));
	     System.out.println("Value for p2: " + map.get(p2));
	}
}
