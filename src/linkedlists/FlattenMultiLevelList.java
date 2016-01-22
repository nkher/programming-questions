package linkedlists;

public class FlattenMultiLevelList {

	public static MultiNode createListHelper(int arr[]) {
		
		MultiNode head = null, temp = null;
		int i, n=arr.length;
		
		for (i=0; i<n; i++) {
			if (head == null) {
				head = temp = new MultiNode(arr[i], null, null);
			}
			else {
				temp.next = new MultiNode(arr[i], null, null);
				temp = temp.next;
			}
		}
		return head;
	}
	
	public static MultiNode createList() {
		
		int arr1[] = {10, 5, 12, 7, 11};
	    int arr2[] = {4, 20, 13};
	    int arr3[] = {17, 6};
	    int arr4[] = {9, 8};
	    int arr5[] = {19, 15};
	    int arr6[] = {2};
	    int arr7[] = {16};
	    int arr8[] = {3};
	    
	    MultiNode head1 = createListHelper(arr1);
	    MultiNode head2 = createListHelper(arr2);
	    MultiNode head3 = createListHelper(arr3);
	    MultiNode head4 = createListHelper(arr4);
	    MultiNode head5 = createListHelper(arr5);
	    MultiNode head6 = createListHelper(arr6);
	    MultiNode head7 = createListHelper(arr7);
	    MultiNode head8 = createListHelper(arr8);
	    
	    head1.child = head2;
	    head1.next.next.next.child = head3;
	    head3.child = head4;
	    head4.child = head5;
	    head2.next.child = head6;
	    head2.next.next.child = head7;
	    head7.child = head8;
	    
	    return head1;
	}
	
	public static void printList(MultiNode head) {
		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.println();
	}
	
	// Time complexity is O(N)
	public static void flattenMultiLevelList(MultiNode head) {
		
		// Base case
		if (head == null) return;
		
		// find the tail
		MultiNode tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
		
		// One by one traverse through all nodes of first level
	    // linked list till we reach the tail node
		MultiNode cur = head;
		
		while (cur != tail) {
			// If current node has a child
			if (cur.child != null) {
				
				// append the child to the list, that means to the tail
				tail.next = cur.child;
				
				// update the tail to the new last
				MultiNode tmp = cur.child;
				while (tmp.next != null) {
					tmp = tmp.next;
				}
				tail = tmp;
			}
			
			// Change the current node
			cur = cur.next;
		}
	}
	
	public static void main(String[] args) {
		
		MultiNode head = createList();
		flattenMultiLevelList(head);
		printList(head);
	}

}

class MultiNode {
	public int data;
	MultiNode next, child;
	
	public MultiNode(int data, MultiNode n, MultiNode c) {
		this.data = data;
		this.next = n;
		this.child = c;
	}
}
