package linkedlists;

import java.util.HashMap;

public class LRUCache {

	DoublyLLNode rear;
	DoublyLLNode front;
	public int capacity;
	private int size;
	HashMap<Integer, DoublyLLNode> hmap = new HashMap<Integer, DoublyLLNode>();
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.size = 0;
	}
	
	
	/** 
	 * Entry in the cache will happen from the rear. */
	public void enqueue(int pageNumber) {
		
		
		if (isCacheFull()) { // if the cache is full remove from both the places
			hmap.remove(rear.data);
			dequeue();
		}
		
		// now adding to the front of the queue
		DoublyLLNode newnode = new DoublyLLNode(pageNumber);
		
		newnode.next = front;
		
		// point the rear and front to the newnode if the cache was previously empty
		if (isCacheEmpty()) { 
			rear = front = newnode;
		}
		else {
			front.prev = newnode;
			front = newnode;
		}
		
		// add to the hashtable
		hmap.put(pageNumber, newnode);
		
		// increment the size
		size++;
	}
	
	/** 
	 * Deletion happens through the rear as we have to remove the last value in the queue. */
	public void dequeue() { // remove from the front
		if (isCacheEmpty()) {
			System.out.println("Sorry nothing to dequeue from the cache !");
			return;
		}
		
		// If this is the only node in the cache
		if (rear == front) {
			front = rear = null;
		}
		
		// Change the pointers of the rear to its previous
		rear = rear.prev;
		
		// make the rear's next as null
		if (rear != null) {
			rear.next = null;
		}
		
		size--; // decrement the size
	}
	
	/** 
	 * Function that handles the request for the reference page in O(1) time using the doubly linked list and the hashmap. */
	public void referencePage(int pageNumber) {
		
		DoublyLLNode requestedPage = hmap.get(pageNumber);
		
		if (requestedPage == null) { // does not contain
			enqueue(pageNumber);
		}
		else if ( requestedPage != front ) { // available in the cache but not at the front
			
			// unlinking prev and next links
			requestedPage.prev.next = requestedPage.next;
			if (requestedPage.next != null) {
				requestedPage.next.prev = requestedPage.prev;
			}
			
			// if rear then change rear
			if (requestedPage == rear) {
				rear = requestedPage.prev;
				rear.next = null;
			}
			
			requestedPage.next = front;
			requestedPage.prev = null;
			
			requestedPage.next.prev = requestedPage; // or same as front.prev = requested page
			
			front = requestedPage;
		}
	}
	public boolean isCacheFull() {
		return this.size == capacity;
	}
	
	public boolean isCacheEmpty() {
		return this.size == 0;
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);
		
		int a[] = {1, 2, 3, 1, 4, 5};
		
		for (int i=0;i<a.length;i++) {
			cache.referencePage(a[i]);
		}
		
		System.out.println(cache.front.data);
		System.out.println(cache.front.next.data);
		System.out.println(cache.front.next.next.data);
		System.out.println(cache.front.next.next.next.data);
	}
}

class DoublyLLNode {
	
	int data;
	DoublyLLNode prev;
	DoublyLLNode next;
	
	public DoublyLLNode(int data) {
		this.data = data;
	}
}
