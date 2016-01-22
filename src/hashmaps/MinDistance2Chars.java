package hashmaps;

import java.util.HashMap;

public class MinDistance2Chars {

	public static int minDistBetweenChars(String s, char x, char y) {
		
		HashMap<Character, Integer> latestFreqMap = new HashMap<Character, Integer>();
		int minDist = Integer.MAX_VALUE;
		
		for (int i=0; i<s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == x) {
				if (latestFreqMap.containsKey(y)) {
					minDist = Math.min(minDist, (i - latestFreqMap.get(y)));
				}
			}
			else if (cur == y) {
				if (latestFreqMap.containsKey(x)) {
					minDist = Math.min(minDist, (i - latestFreqMap.get(x)));
				}
			}
			latestFreqMap.put(cur, i);
		}
		
		return minDist;
	}
	
	public static void main(String[] args) {
		
		String s = "axcaerrade";
		
		System.out.println(minDistBetweenChars(s, 'a', 'e'));
		System.out.println(minDistBetweenChars(s, 'e', 'a'));
	}

}
