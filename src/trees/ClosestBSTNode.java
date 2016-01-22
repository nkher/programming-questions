package trees;

import datastructures.TreeNode;

public class ClosestBSTNode {

	// Time complexity is O(n)
	public static Result closestBSTValue(TreeNode root, int key) {
		Result res = new Result(Integer.MAX_VALUE, new TreeNode(0));
		return closestBSTValueUtil(root, key, res);
	}
	
	public static Result closestBSTValueUtil(TreeNode node, int key, Result result) {
		
		if (node == null) return null;
		
		int diffRoot = getDiff(key, node);

		if (result.leastDiffAsOfNow > diffRoot) {
			result.node = node;
			result.leastDiffAsOfNow = diffRoot;
		}
				
		closestBSTValueUtil(node.left, key, result); 
		closestBSTValueUtil(node.right, key, result);
				
		return result;	
	}
	
	
	public static int getDiff(int key, TreeNode n2) {
		return Math.abs(key - n2.data);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(43);
		root.right = new TreeNode(57);
		root.left.left = new TreeNode(37);
		root.left.right = new TreeNode(46);
		root.right.left = new TreeNode(54);
		root.right.right = new TreeNode(68);
		root.right.right.left = new TreeNode(64);
				
		Result res = closestBSTValue(root, 65);
		System.out.println(res.node.data);
	}
}

class Result {
	int leastDiffAsOfNow;
	TreeNode node;
	
	public Result(int c, TreeNode n) {
		leastDiffAsOfNow = c;
		node = n;
	}
}

