package stringsandarrays;

public class ReverseOddCharsString {
	
	// Here we are not considering '0th character as odd character'. Should ask interviewer.
	public static String reverseOddChars(String s) {
		char str[] = s.toCharArray();
		int start = 1, end = s.length()-1;
		
		// check if end is odd or not
		if ( (end & 1) == 0) {
			end = end - 1;
		}
		
		while (start < end) {
			// swap start and end
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			
			// decrease and increase by 2 instead of 1
			start += 2;
			end -= 2;
		}
		
		return new String(str);
	}

	
	public static void main(String[] args) {
		
		System.out.println(reverseOddChars("Namesh"));
		System.out.println(reverseOddChars("Jack Daniels"));
	}

}
