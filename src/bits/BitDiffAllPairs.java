package bits;

public class BitDiffAllPairs {
	
	/* *
	 * Method1 - Simple solution is to run two loops to consider each pair one by one.
	 * O(N^2)
	 */
	
	/**
	 * Efficient solution - The idea is to count differences at individual bit positions. 
	 * We traverse from 0 to 31 and count numbers with i’th bit set. Let this count be ‘count’. 
	 * There would be “n-count” numbers with i’th bit not set. 
	 * So count of differences at i’th bit would be “count * (n-count) * 2″.
	 */
	public static int calculateBitDifferencesInAllPairs(int[] array) {
		int x = 0, n = array.length;
		
		// traversing over all of the bits
		for (int i=0; i<32; i++) {
			int count = 0; // this is count of the numbers in the array that have i(th) bit set
			for (int j=0; j<n; j++) { // iterate over the array
				if ((array[j] & (1<<i)) == 0) {
					count++;
				}
			}
			x += (count * (n - count) * 2);
		}
		
		return x;
	}
	
	public static void main(String args[]) {
		
		int array[] = {1, 3, 5};
		System.out.println("Answer is : " + calculateBitDifferencesInAllPairs(array));
	}
}
