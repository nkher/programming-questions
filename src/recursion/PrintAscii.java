package recursion;

public class PrintAscii {
	
	public static void printAscii() {
		printAsciiHelper(0);
	}
	
	private static void printAsciiHelper(int x) {
		char y = (char) x;
		System.out.println(x + " -> " + y);
		x += 1;
		if (x < 129) {
			printAsciiHelper(x);
		}
	}
	
	public static void main(String[] args) {
		printAscii();
	}
}
