package trees;

import datastructures.IntWrapper;
import datastructures.TreeNode;

public class KthElementBSTWithoutModifying {
	
	public static IntWrapper count = new IntWrapper(0);
	
	public static TreeNode kthElement(TreeNode node, int k) {
		return kthElementHelper(node, k, count, new TreeNode(0));
	}
	
	public static TreeNode kthElementHelper(TreeNode node, int k, IntWrapper count, TreeNode result) {
		
		if (count.get() > k) return result;
		
		if (node != null) {
			kthElementHelper(node.left, k, count, result);
			count.increment();
			if (count.get() == k) {
				result.data = node.data;
				return result;
			}
			kthElementHelper(node.right, k, count, result);
		}
		
		return result;
	}
	
	public static void inorder(TreeNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}
	
	
	public static void main(String args[]) {
		
		TreeNode root = new TreeNode(50);
		root.insertInOrder(40);
		root.insertInOrder(30);
		root.insertInOrder(70);
		root.insertInOrder(80);
		root.insertInOrder(60);
		root.insertInOrder(46);
		
		inorder(root);
		
		System.out.println();
		
		System.out.println("\n" + kthElement(root, 7).data);
		
	}
}
