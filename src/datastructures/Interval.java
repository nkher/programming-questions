package datastructures;

public class Interval {

	public int start, end;
	
	public Interval() {}
	
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public String toString() {
		return "[" + this.start + ", " + this.end + "]";
	}
	
	public boolean overlaps(Interval intr) {
		return (intr.start >= this.start && intr.start <= this.end && intr.end > this.end);
	}
	
	public boolean covers(Interval intr) {
		return (intr.start >= this.start && intr.end <= this.end);
	}
}
