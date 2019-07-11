package chapter4;

import java.util.ArrayList;

import chapter2.HKLinkedList;

public class Question3 {

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
		
		Question3 q3 = new Question3();
		ArrayList<HKLinkedList> list = new ArrayList<HKLinkedList>();
		
		list = q3.listofdepths(n, list, 0);
		for (int i=0; i<list.size(); i++) {
			list.get(i).printLinkedList();
			System.out.println();
		}
		
	}
	
	public ArrayList<HKLinkedList> listofdepths(HKTreeNode n, ArrayList<HKLinkedList> list,int level) {
		if (n == null) {
			return null;
		} else {
			if (list.size() == level) {
				list.add(new HKLinkedList());
				list.get(level).appendToTail(n.data);
				listofdepths(n.left, list, level+1);
				listofdepths(n.right, list, level+1);
			} else {
				list.get(level).appendToTail(n.data);
				listofdepths(n.left, list, level+1);
				listofdepths(n.right, list, level+1);
			}
		}
		
		return list;
	}

}
