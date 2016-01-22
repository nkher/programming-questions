package linkedlists;

import datastructures.LinkedListNode;

public class NumberOfSequenceElements {
	
	public static void resultTypeDLL(LinkedListNode arr[], LinkedListNode head) {
		
		LinkedListNode curr = head;
		for (int i=0;i<arr.length;i++) {
			LinkedListNode n = arr[i];
			if (n.next != null) {
				n.next.prev = null;
			}
		}
		
		boolean intoSequence = false;
		int count = 0;
		while (curr.next != null) {
			if (curr.next.prev == null) {
				System.out.println(curr.data);
				if (!intoSequence) {
					count++;
					intoSequence = true;
				}
			}
			else {
				intoSequence = false;
				System.out.println();
			}
			curr = curr.next;
		}
		
		System.out.println("count is : " + count);
	}
	
	public static void main(String args[]) {
		
		LinkedListNode node1 = new LinkedListNode(1, null, null);	
		LinkedListNode node2 = new LinkedListNode(2, null, node1);
		LinkedListNode node3 = new LinkedListNode(3, null, node2);
		LinkedListNode node4 = new LinkedListNode(4, null, node3);
		LinkedListNode node5 = new LinkedListNode(5, null, node4);
		LinkedListNode node6 = new LinkedListNode(6, null, node5);
		LinkedListNode node7 = new LinkedListNode(7, null, node6);
		LinkedListNode node8 = new LinkedListNode(8, null, node7);
		LinkedListNode node9 = new LinkedListNode(9, null, node8);
		
		node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        LinkedListNode head = node1;
        
        LinkedListNode[] arr = {node9, node1, node3, node7, node8, node5, node2};
        
        resultTypeDLL(arr, head);
	}
}
