package trees;

import java.util.LinkedList;
import java.util.Queue;

import datastructures.TreeNode;

	
public class SelectNodeAtRandomUnbalancedBinaryTree {
	
	// each node should have equal probability of selection
	// O(n) time and O(1) space
	public static TreeNode selectRandomNode(TreeNode root) {
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode selected = null;
		queue.add(root);
		int number = 1;
		
		while (!queue.isEmpty()) {
			TreeNode curr = queue.remove(); // get the first node
			
			if (curr.left != null) queue.add(curr.left);
			if (curr.right != null) queue.add(curr.right);
			
			System.out.println("Node " + curr.data + " : has chance 1/ " + number);
			if (Math.random() < (1.0/number)) {
				selected = curr;
			}
			number++;
		}
		return selected;
	}
	
	public static void main(String args[]) {
		
		TreeNode root = new TreeNode(10);
		root.insertInOrder(20);
		root.insertInOrder(5);
		root.insertInOrder(30);
		root.insertInOrder(40);
		root.insertInOrder(50);
		root.insertInOrder(35);
		
		// root.print();
		
		System.out.println(selectRandomNode(root).data);
	}
}
