package trees;

import java.util.Stack;

import datastructures.TreeNode;

public class PostOrderSuccessor {
	
	// Post order successor of BST without parent pointer
	public static TreeNode portOrderSucc(TreeNode root, int v) {
		
		if (root.data == v) {
			System.out.println("This is the root node and hence does not have any element after it.");
			return null;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;
		int vSub = v;
		
		/* First push to the stack */
		stack = pushToStack(curr, stack);
		
		// If the current's right is null and current is the node for which you want to find the successor
		// then change the current to the top of the stack which is nothing but currents parent
		// This will get the right siblings leftmost child which is the post order successor for the current node
		while (!stack.isEmpty()) {
			TreeNode parent = stack.pop();
			
			if (parent.data == vSub) { 
				curr = stack.pop();
				if (curr.right != null)
					return leftmost(curr.right);	
			}
			else if (parent.right != null) {
				curr = parent.right;
				if (curr.data == vSub) {
					return parent;
				}
				pushToStack(curr, stack); // push its left nodes
			}
		}
		return null;
	}
	
	public static TreeNode leftmost(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	public static Stack<TreeNode> pushToStack(TreeNode node, Stack<TreeNode> stack) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
		return stack;
	}
		
	public static void postOrder(TreeNode node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data + " ");
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		TreeNode root = new TreeNode(50);
		root.insertInOrder(20);
		root.insertInOrder(70);
		root.insertInOrder(1);
		root.insertInOrder(30);
		root.insertInOrder(60);
		root.insertInOrder(90);

		postOrder(root);
		
		TreeNode postordersucc = PostOrderSuccessor.portOrderSucc(root, 50);
		System.out.println("\n\nPost order successor is : " + postordersucc.data);
	}

}
