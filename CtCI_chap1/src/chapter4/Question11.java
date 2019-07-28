package chapter4;

import java.util.ArrayList;
import java.util.Random;

public class Question11 {

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
		
		Question11 q11 = new Question11();
		HKTreeNode res = q11.getRandomNode(tree);
		System.out.println("result node has data : " + res.data);

	}
	
	public HKTreeNode getRandomNode(HKTree t) {
		
		ArrayList<HKTreeNode> list = new ArrayList<HKTreeNode>();
		list = treeToList(t.root, list);
		
		Random random = new Random();
		int idx = random.nextInt(list.size());
		
		//just in case
		/*
		System.out.println("just in case");
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).data);
		}
		System.out.println("--------------------------------");
		*/
		//
		
		return list.get(idx);
		
	}
	
	public ArrayList<HKTreeNode> treeToList(HKTreeNode n, ArrayList<HKTreeNode> list) {
		if (n == null) {
			return list;
		}
		list.add(n);
		treeToList(n.left, list);
		treeToList(n.right, list);
		return list;
		
	}

}
