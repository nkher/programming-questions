package dynamicprogramming;

import java.util.HashSet;

public class WordBreak {
	
	public static String wordBreakDP(String word, HashSet<String> dict) {
		
		int n = word.length();
		int T[][] = new int[n][n];
		
		// initialize to -1
		for (int i=0; i<T.length; i++) {
			for (int j=0; j<T[i].length; j++) {
				T[i][j] = -1;
			}
		}
		
		// fill the matrix in bottom up manner
		for (int len=1; len<=n; len++) {
			for (int i=0; i<n-len+1; i++) {
				
				int j = i + len - 1; // getting the last index
				String str = word.substring(i, j+1);
				
				if (dict.contains(str)) {
					T[i][j] = i;
					continue;
				}
				
				// find a k between i+1 to j such that T[i][k+1] && T[k][j] are both true
				for (int k=i+1; k<=j; k++) {
					if (T[i][k-1] != -1 && T[k][j] != -1) {
						T[i][j] = k; // here we are giving the split point
						break;
					}
				}
			}
		}
		
		// make the check
		if (T[0][n-1] == -1) {
			return null;
		}
		
		// create space separate word from string is possible 
		StringBuffer sb = new StringBuffer();
		int i=0, j = n-1;
		while (i < j) {
			int k = T[i][j];
			if (i == k) {
				sb.append(word.substring(i, j+1));
				break;
			}
			sb.append(word.substring(i, k) + " ");
			i = k;
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		HashSet<String> dictionary = new HashSet<String>();
		dictionary.add("I");
		dictionary.add("like");
		dictionary.add("to");
		dictionary.add("play");
		dictionary.add("soccer");
		dictionary.add("had");
		dictionary.add("was");
		
		
		System.out.println(wordBreakDP("Iliketoplaysoccer", dictionary));
	}

}
