package chapter4;

public class HKTreeNode {
	State state;
	int data;
	HKTreeNode left;
	HKTreeNode right;
	HKTreeNode parent;
	
	public HKTreeNode(int data) {
		this.data = data;
	}
	
	public void setLeft(HKTreeNode n) {
		this.left = n;
		this.left.parent = this;
	}
	
	public void setRight(HKTreeNode n) {
		this.right = n;
		this.right.parent = this;
	}

}
