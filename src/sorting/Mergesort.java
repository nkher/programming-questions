package Twitter;

import java.util.Arrays;

public class Mergesort {
	
	public void mergesort(int a[]) {
		int len = a.length;
		if (len < 2) return;
		
		int mid = len/2;
		int left[] = new int[mid];
		int right[] = new int[len - mid];
		
		/* Fill the left and right */
		int i;
		for (i=0;i<mid;i++) {
			left[i] = a[i];
		}
		for (i=mid;i<len;i++) {
			right[i-mid] = a[i];
		}
		
		/* Now recurse on the left and right parts */
		mergesort(left);
		mergesort(right);
		
		/* Now start merging */
		merge(left, right, a);
	}
	
	public void merge(int left[], int right[], int a[]) {
		int i=0, j=0, k=0;
		int leftLen = left.length, rightLen = right.length;
		
		while (i < leftLen && j < rightLen) {			
			if (left[i] < right[j]) {
				a[k] = left[i];
				i++;
			}
			else {
				a[k] = right[j];
				j++;
			}
			k++;
		}
		
		/* One of the arrays (left or right) might not have reached the end */
		while (i < leftLen) {
			a[k] = left[i];
			i++;
			k++;
		}
		
		while (j < rightLen) {
			a[k] = right[j];
			j++;
			k++;
		}
	}
	
	public static void main(String[] args) {
		Mergesort object = new Mergesort();
		int a[] = {8,1,4,16,3,1024,0,45,15,23,155};
		System.out.println(Arrays.toString(a));
		object.mergesort(a);
		System.out.println(Arrays.toString(a));
	}

}
