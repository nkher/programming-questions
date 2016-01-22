package datastructures;

public class Pair {
	
	private int x, y;
	
	public Pair() {}
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "[" + this.x + ", " + this.y + "]";
	}
	
	public int x() { return this.x; }
	
	public int y() { return this.y; }
}
