package trees;

import java.util.ArrayList;

import datastructures.TreeNode;

public class PrintRootToLeafBST {
	
	public static void printRootToLeafPaths(TreeNode root) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		printRootToLeafPathsHelper(root, list);
	}
	
	private static void printRootToLeafPathsHelper(TreeNode node, ArrayList<Integer> list) {
		
		if (node == null) {
			return;
		}
		
		// add the node to the list
		list.add(node.data);
		
		if (node.left == null && node.right == null) {
			System.out.print(list.toString() + " \n");
		}
		
		// recurse
		printRootToLeafPathsHelper(node.left, list);
		printRootToLeafPathsHelper(node.right, list);
		
		// remove the top from the list
		list.remove(list.size()-1);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.insertInOrder(1);
		root.insertInOrder(70);
		root.insertInOrder(100);
		root.insertInOrder(-29);
		root.insertInOrder(38);
		root.insertInOrder(23);
		root.insertInOrder(3);
		root.insertInOrder(7);
				
		printRootToLeafPaths(root);
	}

}
