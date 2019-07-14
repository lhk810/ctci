package chapter4;

public class Question6 {

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
		
		Question5 q5 = new Question5();
		System.out.println(q5.checkBST(tree.root,null,null));
		
		Question6 q6 = new Question6();
		HKTreeNode target = tree.root.right.right;
		System.out.println(target.data);
		System.out.println(q6.Successor(target).data);
	}
	
	public HKTreeNode Successor(HKTreeNode n) {
		HKTreeNode searchNode = n;
		if (searchNode.right != null) {
			searchNode = n.right;
			while (searchNode.left != null) {
				searchNode = searchNode.left;
			}
			return searchNode;
		} else {
			while (searchNode.parent != null && searchNode.parent.left != searchNode) {
				searchNode = searchNode.parent;
			}
			return searchNode.parent;
		}
		
		
	}

}
