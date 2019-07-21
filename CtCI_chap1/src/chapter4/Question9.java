package chapter4;

import java.util.ArrayList;

public class Question9 {

	public static void main(String[] args) {
		Question2 q2 = new Question2();
		int[] arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		//arr[3] = 7;
		//arr[4] = 11;
		//arr[5] = 13;
		//arr[6] = 15;
		//arr[7] = 18;
		//arr[8] = 22;
		HKTreeNode n = q2.makeTree(arr, 0, arr.length-1);
		HKTree tree = new HKTree();
		tree.root = n;
		tree.PrintTree(tree.root);
		
		Question9 q9 = new Question9();
		ArrayList<ArrayList<Integer>> list = q9.listofarray(tree.root);
		
		for (int i=0; i<list.size(); i++) {
			for (int j=0; j<list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
		
	}
	
	public ArrayList<ArrayList<Integer>> listofarray(HKTreeNode root) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> sublist = new ArrayList<Integer>();
		sublist.add(root.data);
		
		makelist(root, list, sublist);
		
		return list;
		
		
	}
	
	public void makelist(HKTreeNode root, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> sublist) {
		
		if (root.left !=null) {
			ArrayList<Integer> left = copylist(sublist);
			left.add(root.left.data);
			list.add(left);
			makelist(root.left, list, left);
		}
		
		if (root.right != null) {
			ArrayList<Integer> right = copylist(sublist);
			right.add(root.right.data);
			list.add(right);
			makelist(root.right, list, right);
		}
		
	}
	
	public ArrayList<Integer> copylist(ArrayList<Integer> sublist) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i=0; i<sublist.size(); i++) {
			res.add(sublist.get(i));
		}
		return res;
	}
	
	

}
