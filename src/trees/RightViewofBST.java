package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import datastructures.TreeNode;

public class RightViewofBST {

	public static ArrayList<Integer> rightView(TreeNode root) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) return list;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			
			int size = queue.size();
			
			for (int i=0; i<queue.size(); i++) {
				
				TreeNode top = queue.remove();
				if (i == 0) {
					list.add(top.data);
				}
				
				if (top.left != null) {
					queue.add(top.left);
				}
				
				if (top.right != null) {
					queue.add(top.right);
				}
			}
		}
		
		return list;
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left = new TreeNode(24);
		root.left.right = new TreeNode(120);
				
		System.out.println(rightView(root).toString());
	}

}
