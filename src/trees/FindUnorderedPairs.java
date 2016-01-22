package trees;

import datastructures.TreeNodeMod;

public class FindUnorderedPairs {

	private TreeNodeMod root;
	private int unorderedPairsCount = 0;
	
	public FindUnorderedPairs(int a[]) {
		root = new TreeNodeMod();
		findNumberOfUnorderedPairs(a);
	}
	
	
	private int findNumberOfUnorderedPairs(int a[]) {
		root.setData(a[0]); // inserting the first element
		
		TreeNodeMod crawler = root;
		
		// creating the tree
		for (int i=1; i<a.length; i++) {
			
			crawler = root;
			while (true) {
				if (a[i] < crawler.data()) { // goes to the left
					
					// calculate the unordered pair count
					unorderedPairsCount += crawler.rightSize() + 1;
					if (crawler.left() == null) { // can be inserted
						crawler.setLeft(new TreeNodeMod(a[i]));
						break;
					}
					else {
						crawler = crawler.left();
					}
				}
				else { // goes to the right
					
					crawler.incrementRightSize();
					if (crawler.right() == null) {
						crawler.setRight(new TreeNodeMod(a[i]));
						break;
					}
					else {
						crawler = crawler.right();
					}
				}
			}
		}
		return unorderedPairsCount;
	}
	
	public int getUnorderedPairsCount() {
		return unorderedPairsCount;
	}
	
	public TreeNodeMod root() { return root; } 
	
	public static void main(String[] args) {
		
		int a[] = {3, 2, 4, 1};
		FindUnorderedPairs object = new FindUnorderedPairs(a);
		System.out.println(object.getUnorderedPairsCount());
		
		int b[] = {2, 5, 4, 1, 3};
		FindUnorderedPairs object2 = new FindUnorderedPairs(b);
		System.out.println(object2.getUnorderedPairsCount());
	}
}



