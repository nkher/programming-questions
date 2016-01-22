package stringsandarrays;

import java.util.ArrayList;
import java.util.Arrays;

import datastructures.Interval;

public class MinimizeIntervals {
	
	public static ArrayList<Interval> minimizeOverlappingIntervals(Interval[] intervals) {
		
		ArrayList<Interval> result = new ArrayList<Interval>();
		sortByStart(intervals);
		
		System.out.println(Arrays.toString(intervals));
		
		result.add(intervals[0]);
		Interval last, current;
		
		for (int i=1; i<intervals.length; i++) {
			last = getLastInterval(result);
			current = intervals[i];
						
			if (last.covers(current)) {
				continue;
			}
			else if (current.covers(last)) {
				result.remove(result.size() - 1);
				result.add(current);
			}
			else if (last.overlaps(current)) {
				result.remove(result.size() - 1);
				result.add(new Interval(last.start, current.end));
			}
			else {
				result.add(current);
			}
		}	
		return result;
	}
	
	public static void sortByStart(Interval []intr) {
		
		for (int i=0;i<intr.length-1;i++) {
			
			for (int j=0;j<intr.length-i-1;j++) {
				
				if (intr[j].start > intr[j+1].start) {
					Interval temp = intr[j];
					intr[j] = intr[j+1];
					intr[j+1] = temp;
				}
 			}
		}
	}
	
	public static Interval getLastInterval(ArrayList<Interval> list) {
		if (list == null || list.size() == 0) return null;
		else return list.get(list.size() - 1);
	}

	public static void main(String[] args) {
		
		Interval[] intervals = new Interval[4];
		Interval i1 = new Interval(4, 8);
		Interval i2 = new Interval(3, 5);
		Interval i3 = new Interval(-1, 2);
		Interval i4 = new Interval(10, 12);
		
		intervals[0] = i1;
		intervals[1] = i2;
		intervals[2] = i3;
		intervals[3] = i4;
		
		System.out.println(minimizeOverlappingIntervals(intervals));
	}

}
