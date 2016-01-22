package stringsandarrays;

public class ArrayDuplicates {
	
	// This code would make the integer at index pointed by the current value
	// to negative. For example if are at index 0 and the value there is 1 
	// We take absolute value of 1 and goto index 1 in the array, check if that value is smaller than 0. 
	// If it is then we make that value (at index 1) as negative. Now if there is any other 1 in the array we 
	// it would do the same check but find that the value over there is already negative hence return the result.
	public static int findDups(int a[]) {
		int res = -1, len = a.length;

		if (a == null || len == 0) return -1;
		
		for (int i=0;i<len;i++) {
			
			// error check
			if (len < Math.abs(a[i]) || Math.abs(a[i]) < 1) {
				return res;
			}
			
			if ( a[Math.abs(a[i])] >= 0 ) {
				a[Math.abs(a[i])] = -a[Math.abs(a[i])];
			}
			else {
				res = Math.abs(a[i]);
			}
		}
		
		// remove negatives
		for (int i=0;i<len;i++) {
			a[i] = Math.abs(a[i]);
		}
		
		return res;
	}
	
	public static void main(String args[]) {
		
		int a[] = {1, 2, 3, 4, 4};
		System.out.println("Duplicate element in array is : " + findDups(a));
	}
}
