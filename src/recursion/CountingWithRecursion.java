package YouTube;

public class CountingWithRecursion {
	
	// Sum of n numbers using recursion
	public static int countWithRec(int start, int end) {
		if (start == end) return end;
		else {
			return start + countWithRec(start + 1, end);
		}
	}
	
	public static int countIterative(int start, int end) {
		int sum = 0;
		for (int i=start;i<=end;i++) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Sum of first 100 numbers are : " + countWithRec(1, 100));
		System.out.println("Sum of first 100 numbers are : " + countIterative(1, 100));
		
	}

}
