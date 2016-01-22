package CareerCup.Google;

public class Internationalization {
	
	public static void internationalization(String str) {
		
		StringBuilder sb = new StringBuilder();
		String innerStr = str.substring(1, str.length() - 1);
		int maxLen = str.length() - 2;
		char st = str.charAt(0);
		char en = str.charAt(str.length() - 1);
			
		int currLen = maxLen;
		
		while (currLen > 0) {
			
			for (int i=0; i<=maxLen-currLen; i++) {
				sb.append(st); // first char
				
				// Forming the middle part
				sb.append(innerStr.substring(0, i));
				sb.append(currLen);
				sb.append(innerStr.substring(i + currLen, maxLen));
				
				sb.append(en); // last char
				
				System.out.println(sb.toString());
				sb = new StringBuilder();
			}
			
			currLen--;
		}
	}
	
	public static void main(String args[]) {
		
		String  str = "careercup";
		internationalization(str);
	}
}
