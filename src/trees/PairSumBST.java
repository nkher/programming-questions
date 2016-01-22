package trees;

import java.util.Stack;

import datastructures.TreeNode;

public class PairSumBST {
	
	public static boolean printPairSums(TreeNode root, int sum) {
		
		if (root == null) return false;
		
		Stack<TreeNode> inorderStack = new Stack<TreeNode>();
		Stack<TreeNode> revorderStack = new Stack<TreeNode>();
		
		boolean check1 = true, check2 = true;
		TreeNode curr1 = root, curr2 = root;
		int val1 = 0, val2 = 0;
		
		while (true) {
			
			// inorder traversal without recusion
			while (check1) {
				if (curr1 != null) {
					inorderStack.push(curr1);
					curr1 = curr1.left;
				}
				else {
					if (!inorderStack.isEmpty()) {
						curr1 = inorderStack.pop();
						val1 = curr1.data;
						curr1 = curr1.right;
						check1 = false;
					}
					else {
						check1 = false;
					}
				}
			}
			
			// Find next node in REVERSE Inorder traversal. The only
	        // difference between above and below loop is, in below loop
	        // right subtree is traversed before left subtree
			while (check2) {
				if (curr2 != null) {
					revorderStack.push(curr2);
					curr2 = curr2.right;
				}
				else {
					if (!revorderStack.isEmpty()) {
						curr2 = revorderStack.pop();
						val2 = curr2.data;
						curr2 = curr2.left;
						check2 = false;
					}
					else {
						check2 = false;
					}
				}
			}
			
			// If we find a pair, then print the pair and return. The first
	        // condition makes sure that two same values are not added
			if ( (val1 != val2) && (val1 + val2 == sum)) {
				System.out.println("Pair is found : " + val1 + ", " + val2);
				return true;
			}
			
			else if (val1 + val2 > sum) {
				check2 = false;
			}
			
			else if (val1 + val2 < sum){
				check1 = false;
			}
			
			// If any of the inorder traversals is over, then there is no pair
	        // so return false
			if (val1 >= val2) {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(15);
		root.insertInOrder(10);
		root.insertInOrder(20);
		root.insertInOrder(8);
		root.insertInOrder(12);
		root.insertInOrder(16);
		root.insertInOrder(25);
				
		printPairSums(root, 33);
	}

}
