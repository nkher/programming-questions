package linkedlists;

import datastructures.LinkedListNode;

public class ReverseLL {
		
	LinkedListNode head;
	
	public void reverse(LinkedListNode p) {
		
		if (p.next == null) { // Means you have reached the last element
			head = p;
			return;
		}
		
		// keep recursing till the last element
		reverse(p.next);
		
		LinkedListNode temp = p.next; // this starts from second last element
		temp.next = p;
		p.next = null;
		
	}
	
	public static void main(String args[]) {
		
		ReverseLL ll = new ReverseLL();
		ll.head = new LinkedListNode(10, null, null);
		LinkedListNode second =  new LinkedListNode(20, null, ll.head);
		LinkedListNode third =  new LinkedListNode(30, null, second);
		LinkedListNode fourth =  new LinkedListNode(40, null, third);
		ll.head.next = second;
		second.next = third;
		third.next = fourth;
		
		// priting the ll
		System.out.println(ll.head.printForward());
		
		// reverse the linked list
		ll.reverse(ll.head);
		
		System.out.println(ll.head.printForward());
	}
}
