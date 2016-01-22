package stringsandarrays;

import java.util.Arrays;

public class MoveValToEnd {
	
	public static int[] moveValToEnd(int a[], int val) {
		int valCounter = 0;
		for (int i=0;i<a.length;i++) {
			
			if (a[i] == val) {
				valCounter++;
			} 
			else if (valCounter > 0) { // now swap
				a[i - valCounter] = a[i];
				a[i] = val;
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		
		int a[] = {1,2,3,2,4,4,3,2,6,2,8,9,12,2,2,1};
		System.out.println(Arrays.toString(moveValToEnd(a, 2)));
	}

}
