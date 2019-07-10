package chapter4;

public class HKTree {
	public HKTreeNode root;
	
	public void PrintTree(HKTreeNode n) {
		if (n == null) {
			System.out.println("root is null");
		} else {
			System.out.println("The node has data : " + n.data);
			if (n.left != null) {
				System.out.println("The node has left child : " + n.left.data);
			}
			if (n.right != null) {
				System.out.println("The node has right child : " + n.right.data);
			}
			System.out.println();
			if (n.left != null) {
				PrintTree(n.left);
			}
			if (n.right != null) {
				PrintTree(n.right);
			}
		}
	}
}
