package datastructures;

public class IntWrapper {
	
	int i;
	
	public IntWrapper() {}
	
	public IntWrapper(int i) {
		this.i = i;
	}
	
	public void set(int i) {
		this.i = i;
	}
	
	public int get() {
		return i;
	}
	
	public void increment() {
		i = i + 1;
	}
}
