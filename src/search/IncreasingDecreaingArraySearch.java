package YouTube;

public class IncreasingDecreaingArraySearch {
	
	/* Searching for an element 'k' in an increasing and decreasing array in O(logN) 
	 * The idea is to first find the maximum in the array and then do a binary search
	 * on both the halves */
	public static int searchIncDec(int a[], int k) {
		int s = 0, e = a.length-1;
		int maxElemInd = getMaxIndex(a); // first we get the max index and then search on the left and right halves using binary search
	
		if (a[maxElemInd] == k) return maxElemInd;
		
		int ans = binarySearchAscending(a, s, maxElemInd-1, k);
		if (ans != -1) return ans;
		
		
		ans = binarySearchDescending(a, maxElemInd+1, e, k);
				
		return ans;
	}
	
	public static int binarySearchAscending(int a[], int s, int e, int k) {
		while (s <= e) {
			int mid = s + (e-s)/2;
			int m = a[mid];	
			if (m == k) return mid;
			if (k < m) { // search left half
				e = mid - 1;
			}
			else s = mid + 1; // search right half 
		}
		return -1;
	}
	
	public static int binarySearchDescending(int a[], int s, int e, int k) {
		while (s <= e) {
			int mid = s + (e-s)/2;
			int m = a[mid];	
			if (m == k) return mid;
			if (k < m) { // search right half
				s = mid + 1;
			}
			else e = mid - 1; // search left half 
		}
		return -1;
	}
	
	public static int getMaxIndex(int a[]) {
		int s = 0, e = a.length;
		while (s <= e) {
			int mid = s + (e-s)/2;
			int m = a[mid];	
			if (m > a[mid-1] && m > a[mid+1]) return mid;
			
			if (m < a[mid+1]) { // we are in the increasing sequence therefore search right half
				s = mid + 1;
			}
			else e = mid - 1; // search in the left half 
		}
		return Integer.MIN_VALUE;
	}
	
	public static void main(String args[]) {
		
		int a[] = { 1, 3, 5, 7, 6, 4, 2 }; // 1 4 10 14 18 15 7, 1 5 10 9 8 7 6 
		
		System.out.println(searchIncDec(a, 3));
		System.out.println(searchIncDec(a, 6));
		System.out.println(searchIncDec(a, 7));
		System.out.println(searchIncDec(a, 2));
		System.out.println(searchIncDec(a, 34));
	}
	
}
