package dynamicprogramming;

public class MaximumAs {
	
	// Algorithm - DP
	
	/***
	 * 
	 * a) For N < 7, the output is N itself. b) Ctrl V can be used multiple times to print current buffer (See last two examples above). 
	 * The idea is to compute the optimal string length for N keystrokes by using a simple insight. 
	 * The sequence of N keystrokes which produces an optimal string length will end with a suffix of Ctrl-A, a Ctrl-C, followed by only Ctrl-V's (For N > 6).
	 * 
	 * The task is to find out the break=point after which we get the above suffix of keystrokes. 
	 * Definition of a breakpoint is that instance after which we need to only press Ctrl-A, Ctrl-C once and 
	 * the only Ctrl-V’s afterwards to generate the optimal length. If we loop from N-3 to 1 and 
	 * choose each of these values for the break-point, and compute that optimal string they would produce. 
	 * Once the loop ends, we will have the maximum of the optimal lengths for various breakpoints, 
	 * thereby giving us the optimal length for N keystrokes.
	 * 
	 */
	
	
	/* N is the number of total number of times you can press a key */
	public static int findMaxPossibleAs(int N) {
		
		if (N <= 6) return N;
		
		int[] map = new int[N+1];
		
		// initializing the array
		for (int i=0; i<=6; i++) {
			map[i] = i;
		}
				
		for (int i=7; i<=N; i++) {
			
			// Initialize length of optimal string for n keystrokes
			map[i] = 0;
			
			// For any keystroke n, we need to loop from i-3 keystrokes
	        // back to 1 keystroke to find a breakpoint 'j' after which we
	        // will have ctrl-a, ctrl-c and then only ctrl-v all the way.
			
			for (int j=i-3; j>=1; j--) {
				
				// if the breakpoint is at b'th keystroke then
	            // the optimal string would have length
	            // (i-j-1)*screen[j-1];
				
				int curr = (i-j) * map[j-1];
				if (curr > map[i]) {
					map[i] = curr;
				}
			}
		}
		
		return map[N];
	}
	
	public static void main(String args[]) {
		
		System.out.println(findMaxPossibleAs(3));
		System.out.println(findMaxPossibleAs(7));
		System.out.println(findMaxPossibleAs(11));
		System.out.println(findMaxPossibleAs(20));
	}
}
