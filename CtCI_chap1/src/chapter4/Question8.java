package chapter4;

public class Question8 {

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
		
		Question8 q8 = new Question8();
		HKTreeNode n1 = tree.root.left.right;
		HKTreeNode n2 = tree.root.left.left;
		System.out.println("node1 is " + n1.data);
		System.out.println("node2 is " + n2.data);
		HKTreeNode ancestor = q8.findcommonancestor(n1, n2);
		System.out.println(ancestor.data);

	}
	
	public boolean covers(HKTreeNode root, HKTreeNode t) {
		if (root == null) return false;
		if (root == t) return true;
		return covers(root.left,t) || covers(root.right,t);
	}
	
	public HKTreeNode findcommonancestor(HKTreeNode n1, HKTreeNode n2) {
		if (covers(n1, n2)) {
			return n1;
		}
		if (covers(n1, n2)) {
			return n2;
		}
		while (n1 != null) {
			n1 = n1.parent;
			if (covers(n1,n2)) {
				return n1;
			}
		}
		return null;
	}

}
