package Facebook;

public class Add2BinaryNumbers {
	
	// x = 11, y = 1, result = 100
	
	public static String addBinary(String x, String y) {
		if (x == null || x.length() == 0) return y;
		if (y == null || y.length() == 0) return x;
		
		int px = x.length()-1, py = y.length()-1;
		int flag = 0; // carry 
		StringBuilder sb = new StringBuilder();
		
		while (px >= 0 || py >= 0) {
			int vx = 0, vy = 0;
			
			if (px >= 0) {
				vx = x.charAt(px) == '0' ? 0 : 1;
				px--;
			}
			if (py >= 0) {
				vy = y.charAt(py) == '0' ? 0 : 1;
				py--;
			}
			
			// main calculation
			int sum = vx + vy + flag; // add the last digits along with the flag which is the carry
			if (sum >= 2) {
				sb.append(String.valueOf(sum-2));
				flag = 1; // set the carry to 1 for next time
			}
			else {
				sb.append(String.valueOf(sum));
				flag = 0;
			}
		}
		
		if (flag == 1) {
			sb.append("1");
		}
		
		String reversed = sb.reverse().toString();
		return reversed;
	}
	
	public static void main(String[] args) {
		
		String x = "11", y = "1";
		System.out.println(addBinary(x, y));
		
		x = "1010";
		y = "100";
		System.out.println(addBinary(x, y));
	}

}
