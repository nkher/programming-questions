package CareerCup.Google.Latest;

import java.util.HashMap;

public class OrderByAnotherString {
	
	public static String orderBy(String T, String O) {
		
		if (T == null) return null;
		if (O == null || O.length() < 1) return T;
		
		HashMap<Character, Integer> characterCounts = new HashMap<Character, Integer>();
		for (char c : O.toCharArray()) {
			characterCounts.put(c, 0);
		}
		
		StringBuilder result = new StringBuilder();
		
		// Now get the other characters in the result and simultaneously get the character counts
		for (int i=0; i<T.length(); i++) {
			char ch = T.charAt(i);
			if (characterCounts.containsKey(ch)) {
				characterCounts.put(ch, characterCounts.get(ch) + 1);
			}
			else {
				result.append(ch);
			}
		}
		
		// Iterating over the order string to get the priority
		for (int i=0;i<O.length();i++) {
			char ch = O.charAt(i);
			int charCount = characterCounts.get(ch);
			while (charCount > 0) {
				result.append(ch);
				charCount--;
			}
		}
		
		return result.toString();
	}
	
	public static void main(String args[]) {
		
		String T = "xyefrfghgyyi";
		String O = "gyxie";
		
		// out put should be  - erhggffyyyxi
		
		System.out.println(orderBy(T, O));
	}
}
