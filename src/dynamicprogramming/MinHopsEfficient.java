package dynamicprogramming;

public class MinHopsEfficient {

	public static int minHopsOptimized(int a[]) {
		
		int n = a.length;
		if (n == 0 || n == 1) return 0;
		int m = 0, i = 0, nJumps = 0;
		
		while (i < n) {
			
			m = Math.max(m, a[i] + i);
			if (m > 0) { // means we have made  a jump
				nJumps++;
			}
			if (m >= n-1) { // check if we have reached the end
				return nJumps;
			}
			int tmp = 0;
			for (int j=i+1; j<=m; j++) { // from current i to m we are finding the maximum that we can jump and updating i to that position
				if (j + a[j] > tmp) {
					tmp = j + a[j];
					i = j;
				}
			}
		}
		
		return nJumps;
	}
	
	public static void main(String[] args) {
		
		int a[] = {2, 3, 1, 1, 4};
		System.out.println(minHopsOptimized(a));
	}

}
