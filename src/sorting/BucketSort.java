package sorting;

import java.util.ArrayList;
import java.util.Random;

public class BucketSort {
	
	public ArrayList<Integer> bucketsort(ArrayList<Integer> list, int maxValue) {
		
		int size = list.size();
		LinkedList[] buckets = new LinkedList[10];
		// hash function is : (value * n) / maxValue
		
		/* Step 1 is to fill the buckets */
		for (Integer i : list) {
			
			LinkedList linkedList;
			int hash = i*10 / maxValue;
				if (buckets[hash] == null) {
				buckets[hash] = new LinkedList();
			}
			linkedList = buckets[hash];
			linkedList.insertInOrder(new LLNode(i));
		}
		
		
		
		/* Step 2 is to refill the array as the linked lists in the buckets are already sorted */
		int writeInd = 0; // To write to the correct index in the array
		list.clear(); // clearing the list
		for (LinkedList linkedList : buckets) {
			
			if (linkedList != null) {
				System.out.println();
				linkedList.print();
				LLNode tempHead = linkedList.head();
				while (tempHead != null) {
					list.add(writeInd++, tempHead.data);
					tempHead = tempHead.next;
				}
			}
		}
		
		return list;
	}
	
	
	public static void main(String[] args) {
		
		BucketSort bsort = new BucketSort();
		int high = 100, low = 0, length = 10;
		Random random = new Random();
		ArrayList<Integer> list =  new ArrayList<Integer>();
		
		for (int i=0;i<length;i++) {
			list.add(random.nextInt( high - low ) + low);
		}	
		
		int max = Integer.MIN_VALUE;
		for (Integer i : list) {
			max = Math.max(max, i);
		}
		
		System.out.println("Max is : " + max);
		
		System.out.println("Array before sorting : " + list.toString());
		
		/* Sorting the array using bucket sort */
		bsort.bucketsort(list, max+1);
		
		System.out.println("\n\nArray after sorting : " + list.toString());
	}
}

class LLNode {
	int data;
	LLNode next;
	
	public LLNode(int d) {
		data = d;
		next = null;
	}
	
	public LLNode(int d, LLNode n) {
		data = d;
		next = n;
	}
}

class LinkedList {
	
	private LLNode head;
	
	public LinkedList() {
		
	}
	
	public LLNode head() {
		return head;
	}
	
	public LinkedList(LLNode h) {
		head = h;
	}
	
	/* To add a node to the linked list in sorted manner - O(N) */
	public void insertInOrder(LLNode node) {
		if (head == null) {
			head = new LLNode(node.data);
		}
		
		LLNode curr = head, prev = null;
		
		while (curr != null) {
			if (curr.data > node.data) {
				node.next = curr;	
				if (curr == head) { /* If node to be inserted is the smallest then add it to the head */
					head = node;
					return;
				}
				prev.next = node;
			}
			// cascade
			prev = curr;
			curr = curr.next;
		}
	}
	
	public void print() {
		LLNode temp = head;
		System.out.print("[ ");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.print("]");
	}
}