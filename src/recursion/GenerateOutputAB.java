package recursion;

import datastructures.IntWrapper;

public class GenerateOutputAB {
	
	public static IntWrapper count = new IntWrapper(0);
	
	public static void generateOutput(int n) {
		int k = 1;
		while ( (1 << k) < n) {
			k++;
		}		
		for (int i=1;i< (k+1);i++) {
			generateOutputHelper(count, n, i, new char[i], 0);
		}
	}
	
	public static void generateOutputHelper(IntWrapper count, int n, int i, char array[], int index) {
		
		if (count.get() < n && index == i) {
			printArray(array);
			count.set(count.get() + 1);
		}		
		if (index < i) {
			array[index] = 'A';
			generateOutputHelper(count, n, i, array, index + 1);
			array[index] = 'B';
			generateOutputHelper(count, n, i, array, index + 1);
			array[index] = ' ';
		}
	}
	
	public static void printArray(char array[]) {
		for (int i=0;i<array.length;i++) {
			System.out.print(array[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		generateOutput(15);		
	}

}
