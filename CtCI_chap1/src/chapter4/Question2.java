package chapter4;

public class Question2 {

	public static void main(String[] args) {
		Question2 q2 = new Question2();
		int[] arr = new int[7];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		arr[3] = 7;
		arr[4] = 11;
		arr[5] = 13;
		arr[6] = 18;
		
		HKTreeNode n = q2.makeTree(arr, 0, arr.length-1);
		HKTree Tree = new HKTree();
		Tree.root = n;
		
		Tree.PrintTree(n);

	}
	
	public HKTreeNode makeTree(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end)/2;
		HKTreeNode n = new HKTreeNode(arr[mid]);
		n.left = makeTree(arr, start, mid-1);
		if (n.left != null) {
			n.left.parent = n;
		}
		n.right = makeTree(arr, mid+1, end);
		if (n.right != null) {
			n.right.parent = n;
		}
		return n;
	}

}
