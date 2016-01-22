package CareerCup.Google.Latest;

import java.util.Arrays;

public class RearrangeLettersNumbers {
	
	// This does not guarantee the order of the numbers at the last
	public static char[] moveNumbersToEnd(char[] a) {
		int numCount = 0;
		for (int i=0; i<a.length; i++) {
			char ch = a[i];
			if (isDigit(ch)) {
				numCount++;
			}
			else if  (numCount > 0) {
				swapAt(a, i, i - numCount);
			}
		}
		return a;
	}
	
	public static void swapAt(char[] a, int idx1, int idx2) {
		char temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	public static boolean isDigit(char c) {
		int n = c - '0';
		return (n >= 0 && n <= 9);
	}
	
	public static void main(String[] args) {
		
		String s = "a1b2c3d4";
		String x = "x3y4z6";
		
		System.out.println(Arrays.toString(moveNumbersToEnd(s.toCharArray())));
		
		System.out.println(Arrays.toString(moveNumbersToEnd(x.toCharArray())));
	}

}
