package Yelp;

public class LowerUpperCase {
	
	
	/* Assumes that you pass a lower case String */
	public static void lowerUpper(String s) {
		lowerUpperHelper(s.toCharArray(), 0);
	}
	
	private static void lowerUpperHelper(char word[], int pos) {
		if (pos == word.length) {
			System.out.println(new String(word));
			return;
		}
		/* Change the next character to upper case */
		word[pos] = Character.toUpperCase(word[pos]);
		lowerUpperHelper(word, pos+1);
		
		/* Change the same character which was changed earlier to lower case 
		 */
		word[pos] = Character.toLowerCase(word[pos]);
		lowerUpperHelper(word, pos+1);
	}
	
	public static void main(String[] args) {
		lowerUpper("abc");
	}

}
