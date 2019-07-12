package chapter4;

import java.util.ArrayList;

public class Question5 {

	public static void main(String[] args) {
		HKTree tree = new HKTree();
		tree.root = new HKTreeNode(8);
		tree.root.left = new HKTreeNode(4);
		tree.root.left.parent = tree.root;
		tree.root.right = new HKTreeNode(10);
		tree.root.right.parent = tree.root;
		tree.root.left.left = new HKTreeNode(2);
		tree.root.left.left.parent = tree.root.left;
		tree.root.left.right = new HKTreeNode(12);
		tree.root.left.right.parent = tree.root.left;
		tree.root.right.right = new HKTreeNode(20);
		tree.root.right.right.parent = tree.root.right;
		
		Question5 q5 = new Question5();
		System.out.println(q5.checkBST(tree.root,null,null));

	}
	
	public boolean checkBST(HKTreeNode n, Integer min, Integer max) {
		//존나 못풀겠네 이 문제;
		
		if (n == null) {
			return true;
		}
		
		
		if (min != null && n.data <= min || max != null && n.data > max ) {
			return false;
		}
		
		if (!checkBST(n.left, min, n.data) || !checkBST(n.right,n.data,max)) {
			return false;
		}
		
		return true;
		
		
	}
	

}
