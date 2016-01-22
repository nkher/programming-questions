package CareerCup.Google.Latest;

public class GetBreakingPoint {

	/** Point at which sum of elements in left part of array and 
	 *  sum in right part of array are equal.
	 * */
	public static void getBreakingPoint(int a[]) {
		int sum1 = 0, sum2 = 0;
		
		for (int i : a) {
			sum1 += i;
		}
		for (int i=0; i<a.length; i++) {
			sum2 += a[i];
			sum1 -= a[i];
			if (sum1 == sum2) {
				System.out.println("Breaking point is : " + i);
			}
		}
	}
	
	public static void main(String[] args) {
		
		int a[] = {1, 2, 3, 4, 5, 2, 5, 4, 4};
		getBreakingPoint(a);
		
		int b[] = {1, 0, -1, -1, 1};
		getBreakingPoint(b);
		
		int c[] = {1, -1, 0, 1, 1};
		getBreakingPoint(c);
	}

}
