package trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import datastructures.TreeNode;

public class SerializeDeserializeBST {
	
	/* 
	 * Case 1 : If BST then use a post order or pre order traversal
	 * 
	 * Case 2 : If complete binary tree then it is a binary heap. Use a level order traversal to store such a tree. 
	 * 			First node is a root. Next 2 are of next level and so on ...
	 * 
	 * Case 3 : For a full binary tree every node has either 0 or 2 children. Store the pre order traversal of the tree 
	 * 			and store a bit with every node to indicate whether the node is an internal node or a leaf node.
	 * 
	 * Case 4 : For a general binary tree. Store both inorder and preorder traversals.This solution requires requires space twice the size of Binary Tree.
	 *			We can save space by storing Preorder traversal and a marker for NULL pointers.
	 * 
	 * */
	
	// Here we are presenting the program only for a binary tree
	
	/* Serializing a BST */
	public static final int MARKER = -1;
	
	public static void serialize(TreeNode root, File file) {
		
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		serializeHelper(root, bw);
		
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void serializeHelper(TreeNode node, BufferedWriter bw) {
		
		if (node == null){
			try {
				bw.write(MARKER);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		
		// Else store current node and recur for its children
		try {
			bw.write(node.data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		serializeHelper(node.left, bw);
		serializeHelper(node.right, bw);
	}
	/* Serializing a BST */
	
	/* De - Serializing a BST */
	
	public static TreeNode root;
	
	public static TreeNode deSerialize(File file) {
			
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		root = deSerializeHelper(br);
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return root;
	}
	
	private static TreeNode deSerializeHelper(BufferedReader br) {
		
		Integer val = null;
		try {
			val = br.read();
			System.out.println("Val is : " + val);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		if (val == null || val == -1 || val == 65535) {
			return null;
		}
		
		TreeNode node = new TreeNode(val);
		node.left = deSerializeHelper(br);
		node.right = deSerializeHelper(br);
		
		return node;
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
				
		File file = new File("op/serializedBT");
		
		serialize(root, file);
		
		TreeNode r2 = null;
		r2 = deSerialize(file);
				
	}

}
