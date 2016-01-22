package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructures.TreeNode;

public class LeftViewBinaryTree {

	public static List<Integer> leftViewBinaryTree(TreeNode root) {
		
		List<Integer> leftView = new ArrayList<Integer>();
		
		if (root == null) return leftView;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			
			int size = queue.size();
			
			for (int i=0; i<size; i++) {
				
				TreeNode top = queue.remove(); 
				if (i == 0) {
					leftView.add(top.data);
				}
				
				if (top.left != null) {
					queue.add(top.left);
				}
				
				if (top.right != null) {
					queue.add(top.right);
				}
			}
		}
		
		return leftView;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
				
		System.out.println("Left view of binary tree : " + leftViewBinaryTree(root));
	}

}
