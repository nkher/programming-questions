package linkedlists;

import datastructures.LinkedListNode;

public class SortList012 {
	
	// TC = O(N)
	public static LinkedListNode sortList012(LinkedListNode head) {
		
		if (head == null) return null;
		
		int count[] = {0, 0, 0};
		LinkedListNode temp = head;
		
		// storing the counts
		while (temp != null) {
			count[temp.data]++;
			temp = temp.next;
		}
				
		int i=0;
		LinkedListNode ptr = head;
		
		for (i=0; i<count.length; i++) {
			
			if(count[i] == 0) {
				continue;
			}
			while (count[i] > 0) {
				ptr.data = i;
				count[i]--;
				ptr = ptr.next;
			}
		}
		
		return head;
	}

	public static void main(String[] args) {
		
		LinkedListNode n10 = new LinkedListNode(1, null, null);
		LinkedListNode n9 = new LinkedListNode(2, n10, null);
		LinkedListNode n8 = new LinkedListNode(1, n9, null);
		LinkedListNode n7 = new LinkedListNode(0, n8, null);
		LinkedListNode n6 = new LinkedListNode(0, n7, null);
		LinkedListNode n5 = new LinkedListNode(2, n6, null);
		LinkedListNode n4 = new LinkedListNode(2, n5, null);
		LinkedListNode n3 = new LinkedListNode(1, n4, null);
		LinkedListNode n2 = new LinkedListNode(1, n3, null);
		LinkedListNode n1 = new LinkedListNode(0, n2, null);
		LinkedListNode head = new LinkedListNode(2, n1, null);
		
		System.out.println(head.printForward());
		
		head = sortList012(head);
		
		System.out.println(head.printForward());
	}

}
