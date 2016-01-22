package CareerCup.Google.Latest;

public class AddWithoutOperator {
	
	// Half adder logic
	// XOR gives sum of x and y
	// & gives the carry
	public static int add(int x, int y) {
		
		while (y != 0) {
			
			// carry has the common set bits
			int carry = x & y;
			
			// sum of the bits of x and y where at least one of the bits is not set
			x = x ^ y;
					
			// carry is shifted by 1 so that adding to x gives the required sum
			y = carry << 1;
		}
		return x;
	}
	
	
	public static void main(String args[]) {
		
		System.out.println(add(5, 10));
	}
}
