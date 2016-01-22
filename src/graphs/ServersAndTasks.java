package CareerCup.Google.Latest;

public class ServersAndTasks {
	
	// TC = O(8 ^ (t.length))
	public static boolean dfs(int s[], int t[]) {
		return dfsUtil(s, t, 0);
	}
	
	public static boolean dfsUtil(int s[], int t[], int position) {
		boolean result = false;
		if (position >= t.length) { // all tasks have been processed
			return true;
		}
		for (int i=0; i<s.length; i++) {
			if (s[i] - t[position] >= 0) { // means if server still has more capacity
				s[i] = s[i] - t[position]; // get the new capacity
				result |= dfsUtil(s, t, position + 1); // check if the next task can also be scheduled
				s[i] += t[position]; // means the next task cannot be scheduled
			}
		}
		return result;
	}
	
    
	public static void main(String args[]) {
		
		int s[] = {8, 16, 8, 32};
		int t[] = {18, 4, 8, 4, 6, 6, 8, 8};
		
		System.out.println(dfs(s, t));
				
		int s1[] = {1, 3};
		int t1[] = {4};
		
		System.out.println(dfs(s1, t1));
	}
}
