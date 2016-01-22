package Twitter;

import java.util.Arrays;

public class Quicksort {
	
	public void quicksort(int a[], int low, int high) {
		if (high > low) {
			int pIndex = partition(a, low, high);
			quicksort(a, low, pIndex-1);
			quicksort(a, pIndex+1, high);
		}
	}
	
	public int partition(int a[], int low, int high) {
		int pIndex = low, pivot = a[high];
		for (int i=low;i<high;i++) {
			if (a[i] < pivot) {
				int temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		
		// Swap pIndex and pivot
		int temp = a[pIndex];
		a[pIndex] = pivot;
		a[high] = temp;
		return pIndex;
	}
	
	public static void main(String[] args) {
		
		Quicksort object = new Quicksort();
		int a[] = {8,1,4,16,3,1024,0};
		
		System.out.println(Arrays.toString(a));
		
		object.quicksort(a, 0, a.length-1);
		
		System.out.println(Arrays.toString(a));
	}

}
