package datastructures;

public class TreeNodeMod {
	
	private int data, rightSize;
	TreeNodeMod left, right;
	
	public TreeNodeMod() {
		this.rightSize = 0;
	}
	
	public TreeNodeMod(int data) {
		this.data = data;
		this.rightSize = 0;
	}
	
	public int data() { return data; }
	
	public TreeNodeMod left() { return left; }
	
	public TreeNodeMod right() { return right; }
	
	public int rightSize() { return this.rightSize; }
	
	public void setData(int data) {
		this.data = data;
	}

	public void setLeft(TreeNodeMod left) {
		this.left = left;
	}
	
	public void setRight(TreeNodeMod right) {
		this.right = right;
	}
	
	public void incrementRightSize() {
		this.rightSize++;
	}
	
}