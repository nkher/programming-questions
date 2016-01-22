package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewBinaryTree {
	
	public static void printBottomViewTree(TreeNodeMod root) {
		
		int hd = 0;
		
		TreeMap<Integer, Integer> treemap = new TreeMap<Integer, Integer>();
		Queue<TreeNodeMod> queue = new LinkedList<TreeNodeMod>();
		
		root.hd = hd; // assigning 0 hd to the root
		queue.add(root);
		
		while (!queue.isEmpty()) {
			
			TreeNodeMod node = queue.poll();
			
			hd = node.hd;
			
			// Put the dequeued tree node to TreeMap having key
            // as horizontal distance. Every time we find a node
            // having same horizontal distance we need to replace
            // the data in the map.
			treemap.put(hd, node.data);
			
			// If the dequeued node has a left child add it to the
            // queue with a horizontal distance hd-1.
			if (node.left != null) {
				node.left.hd = hd-1;
				queue.add(node.left);
			}
			
			// If the dequeued node has a left child add it to the
            // queue with a horizontal distance hd+1.
			if (node.right != null) {
				node.right.hd = hd+1;
				queue.add(node.right);
			}
		}
		
		for (Integer i : treemap.keySet()) {
			System.out.println(treemap.get(i));
		}
		
	}

	public static void main(String[] args) {
		
		TreeNodeMod root = new TreeNodeMod(20);
		root.left = new TreeNodeMod(8);
		root.right = new TreeNodeMod(22);
		root.right.left = new TreeNodeMod(4);
		root.left.left = new TreeNodeMod(5);
		root.left.right = new TreeNodeMod(3);
		root.left.right.left = new TreeNodeMod(10);
		root.left.right.right = new TreeNodeMod(14);
		root.right.right = new TreeNodeMod(25);
		
		printBottomViewTree(root);
	}

}

class TreeNodeMod {
	
	TreeNodeMod left, right;
	int hd;
	int data;
	
	public TreeNodeMod(int data) {
		this.data = data;
		hd = Integer.MAX_VALUE;
		left = right = null;
	}
}
