package chapter4;

import java.util.ArrayList;

import chapter2.HKLinkedList;

public class Question4 {

	public static void main(String[] args) {
		Question2 q2 = new Question2();
		int[] arr = new int[6];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		arr[3] = 7;
		arr[4] = 11;
		arr[5] = 13;
		//arr[6] = 18;
		
		HKTreeNode n = q2.makeTree(arr, 0, arr.length-1);
		HKTree Tree = new HKTree();
		Tree.root = n;
		Tree.PrintTree(n);
		
		Question4 q4 = new Question4();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = q4.getNumberOfNodes(n, list, 0);
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
			System.out.println();
		}
		System.out.println(q4.checkNumberOfNodes(list));

	}
	
	public ArrayList<Integer> getNumberOfNodes(HKTreeNode n, ArrayList<Integer> list,int level) {
		if (n == null) {
			return null;
		} else {
			if (list.size() == level) {
				list.add(1);
			} else {
				list.set(level, list.get(level)+1);
			}
			getNumberOfNodes(n.left, list, level+1);
			getNumberOfNodes(n.right, list, level+1);
		}
		
		return list;
	}
	
	public boolean checkNumberOfNodes(ArrayList<Integer> list) {
		if (list.size()==0) {return false;}
		int prev_num = list.get(0);
		for (int i=1; i<list.size(); i++) {
			if (list.get(i)%prev_num != 0) {
				return false;
			} else {
				prev_num = list.get(i);
			}
		}
		return true;
	}

}
