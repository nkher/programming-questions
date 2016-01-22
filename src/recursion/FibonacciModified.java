package CareerCup.Google.Latest;

import java.util.ArrayList;
import Library.*;


/** *
 * @author nameshkher
 * Program to display a pair of integers (using fibonacci sequence) where the
 * First value - is the second value of the previous pair
 * Second value - is the last digit of the number produced by the fib sequence
 */
public class FibonacciModified {
	
	public static int map[];
	
	public static ArrayList<Pair> fibModified(int n) {
		
		initMap(n); // initialize the map
		ArrayList<Pair> result = new ArrayList<Pair>();
		int prevY, currY;
		
		for (int i=0;i<n; i++) {
			prevY = (i == 0) ? 1 : result.get(i-1).y();
			currY = fib(i + 1) % 10;
			result.add(new Pair(prevY, currY));
		}
		return result;
	}	
	
	public static int fib(int n) {
		
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		else if(map[n] > -1) {
			return map[n];
		}
		
		else {
			map[n] = fib(n-1) + fib(n-2);
			return map[n];
		}
	}
	
	public static void initMap(int n) {
		
		map = new int[n+1];
		for (int i=0;i<map.length;i++) {
			map[i] = -1;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(fibModified(9).toString());
	}

}
