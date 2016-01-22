package CareerCup.Google.Latest;

public class RepeatingSubsequence {

	// Dynamic programming
	public static int longestRepeatingSequence(String s) {
		
		int n = s.length();
		char sArr[] = s.toCharArray();
		
		int lrs[][] = new int[n][n];
		
		// First row
		for (int i=1; i<n; i++) {
			if (sArr[0] == sArr[i]) {
				lrs[0][i] = 1;
			}
			else {
				lrs[0][i] = lrs[0][i-1]; // comes from the left cell
			}
		}
		
		// first col
		for (int j=1; j<n; j++) {
			if (sArr[j] == sArr[0]) {
				lrs[j][0] = 1;
			}
			else {
				lrs[j][0] = lrs[j-1][0]; // top cell
			}
		}
		
		// rest of the array
		for (int i=1; i<n; i++) {
			for (int j=1; j<n; j++) {
				if (sArr[i] == sArr[j] && i != j) {
					lrs[i][j] = Math.max(lrs[i-1][j-1] + 1, Math.max(lrs[i-1][j], lrs[i][j-1]));
				}
				else {
					lrs[i][j] = Math.max(lrs[i-1][j], lrs[i][j-1]);
				}
			}
		}
		
		return lrs[n-1][n-1];
	}
	
	public static void main(String[] args) {
		
		String s = "abba";
		String x = "abab";
		String y = "acbdaghfb";
		String a = "abcdacbc";
		
		System.out.println(longestRepeatingSequence(s));
		System.out.println(longestRepeatingSequence(x));
		System.out.println(longestRepeatingSequence(y));
		System.out.println(longestRepeatingSequence(a));
	}

}
