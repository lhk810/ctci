package chapter4;

public class Question10 {

	public static void main(String[] args) {
		Question2 q2 = new Question2();
		int[] arr = new int[9];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		arr[3] = 7;
		arr[4] = 11;
		arr[5] = 13;
		arr[6] = 15;
		arr[7] = 18;
		arr[8] = 22;
		HKTreeNode n = q2.makeTree(arr, 0, arr.length-1);
		HKTree tree = new HKTree();
		tree.root = n;
		tree.PrintTree(tree.root);
		
		Question10 q10 = new Question10();
		System.out.println(q10.isSubtree(n.left.left, n.right.left));

	}
	
	public HKTreeNode findRoot(HKTreeNode n) {
		HKTreeNode node = n;
		while (node.parent != null) {
			node = node.parent;
		}
		return node;
	}
	
	public boolean isSubtree(HKTreeNode n1, HKTreeNode n2) {
		HKTreeNode root1 = findRoot(n1);
		HKTreeNode root2 = findRoot(n2);
		if (root1 == root2) {
			return true;
		} else {
			return false;
		}
	}

}
