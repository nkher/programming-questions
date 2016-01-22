package dynamicprogramming;

/***
 * 
 * Reference : (Tushar Roy)
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MatrixMultiplicationCost.java
 */
public class MatrixMultiplication {
	
	public static int findCost(int a[]) {
		
		int n = a.length;
		int T[][] = new int[n][n];
		int q = 0;
		for (int l=2; l<n; l++) {
			for (int i=0; i<n-l; i++) {
				int j = i+l;
				T[i][j] = Integer.MAX_VALUE;
				for (int k=i+1; k<j; k++) {
					q = T[i][k] + T[k][j] + (a[i] * a[k] * a[j]); 
					T[i][j] = Math.min(q, T[i][j]);
				}
			}
		}
		
		return T[0][n-1];
	}
	
	public static void main(String[] args) {

		int a[] = {4,2,3,5,3};
		System.out.println(findCost(a));
		
		int b[] = {2,3,6,4,5};
		System.out.println(findCost(b));
	}

}
