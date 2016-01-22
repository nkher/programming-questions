package search;

public class NumbersInRange {
	
	/** Using modified binary search */
	public static int getFirstIndexOf(int a[], int k) {
		int left = 0, right = a.length;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (a[mid]  == k && a[mid-1] < k) {
				return mid;
			}
			else if ( (a[mid] == k && a[mid-1] == k) || a[mid] > k ) { // go left
				right = mid - 1;
			}
			else { // search on the right half
				left = mid + 1;
			}
		}
		
		return left;
	}
	
	/** Using modified binary search */
	public static int getLastIndexOf(int a[], int k) {
		int left = 0, right = a.length;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (a[mid]  == k && a[mid+1] > k) {
				return mid;
			}
			else if ( (a[mid] == k && a[mid+1] == k) || a[mid] < k ) { // go right
				left = mid + 1;
			}
			else { // search on the right half
				right = mid - 1;
			}
		}
		return right;
	}
	
	public static int getNumberOfElementsInRange(int a[], int min, int max) {
		
		int minIndex = getFirstIndexOf(a, min);
		int maxIndex = getLastIndexOf(a, max);
		System.out.println(maxIndex + " " + minIndex);
		return (maxIndex - minIndex + 1);
	}
	
	public static void main(String[] args) {
		
		int a[] = {2,4,4,4,8,9,9,11};
		
		System.out.println("Number of elements within range are : " + getNumberOfElementsInRange(a, 4, 9));
		
		int b[] = {2,4,4,4,8,9,9,9,9,9,9,9,9,9,11};
		
		System.out.println("Number of elements within range are : " + getNumberOfElementsInRange(b, 4, 9));
	}
}
